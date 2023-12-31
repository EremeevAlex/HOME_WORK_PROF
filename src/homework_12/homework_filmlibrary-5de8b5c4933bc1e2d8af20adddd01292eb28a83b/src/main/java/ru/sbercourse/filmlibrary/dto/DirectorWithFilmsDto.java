package homework_12.homework_filmlibrary;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DirectorWithFilmsDto extends DirectorDto {

  private Set<FilmDto> films;
}
