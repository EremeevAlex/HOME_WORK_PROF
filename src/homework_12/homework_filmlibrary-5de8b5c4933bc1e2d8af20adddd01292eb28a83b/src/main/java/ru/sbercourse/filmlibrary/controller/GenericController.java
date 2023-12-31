package homework_12.homework_filmlibrary;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.sbercourse.filmlibrary.dto.GenericDto;
import ru.sbercourse.filmlibrary.mapper.GenericMapper;
import ru.sbercourse.filmlibrary.model.GenericModel;
import ru.sbercourse.filmlibrary.service.GenericService;

import java.util.List;

@SecurityRequirement(name = "Bearer Authentication")
public abstract class GenericController<E extends GenericModel, D extends GenericDto> {
    protected GenericService<E> service;
    protected GenericMapper<E, D> mapper;


    @Operation(summary = "Получить все записи", description = "Позволяет получить полный список записей",
            method = "getAll")
    @GetMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<D>> getAll() {
        List<E> resultingList = service.listAll();
        return resultingList.isEmpty() ? ResponseEntity.status(HttpStatus.NO_CONTENT).build()
                : ResponseEntity.ok(mapper.toDtos(resultingList));
    }

    @Operation(summary = "Получить запись по ID", description = "Позволяет получить одну запись по заданному ID",
            method = "getById")
    @GetMapping(value = "/getById", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<D> getById(@RequestParam("id") @Parameter(description = "Идентификатор записи") Long id) {
        return ResponseEntity.ok(mapper.toDto(service.getOne(id)));
    }

    @Operation(summary = "Создать новую запись", description = "Позволяет создать переданную запись",
            method = "create")
    @PostMapping(value = "/create", consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<D> create(@RequestBody D newDto) {
        return newDto.getId() != null && service.existsById(newDto.getId()) ?
                ResponseEntity.status(HttpStatus.CONFLICT).build()
                : ResponseEntity.status(HttpStatus.CREATED)
                .body(mapper.toDto(service.create(mapper.toEntity(newDto))));
    }

    @Operation(summary = "Изменить существующую запись", description = "Позволяет заменить существующую запись на обновленную",
            method = "update")
    @PutMapping(value = "/update", consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<D> update(@RequestBody D updatedDto) {
        return updatedDto.getId() != null && service.existsById(updatedDto.getId()) ?
                ResponseEntity.ok(mapper.toDto(service.update(mapper.toEntity(updatedDto))))
                : ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).build();
    }

    @Operation(summary = "Удалить запись по ID", description = "Позволяет удалить запись по заданному ID",
            method = "deleteById")
    @DeleteMapping(value = "/deleteById")
    public ResponseEntity<D> deleteById(@RequestParam("id") @Parameter(description = "Идентификатор записи") Long id) {
        if (service.existsById(id)) {
            service.delete(id);
            return ResponseEntity.ok().build();
        } else return ResponseEntity.notFound().build();
    }

    @Operation(summary = "Софт удаление по ID", description = "Позволяет пометить запись на удаление по заданному ID")
    @DeleteMapping(value = "/softDelete/{id}")
    public void softDelete(@PathVariable(value = "id") Long id) {
        service.softDelete(id);
    }

    @Operation(summary = "Восстановление записи по ID", description = "Позволяет убрать метку записи на удаление по заданному ID")
    @PutMapping(value = "/restore/{id}")
    public void restore(@PathVariable(value = "id") Long id) {
        service.restore(id);
    }


    protected void setService(GenericService<E> service) {
        this.service = service;
    }

    public void setMapper(GenericMapper<E, D> mapper) {
        this.mapper = mapper;
    }
}
