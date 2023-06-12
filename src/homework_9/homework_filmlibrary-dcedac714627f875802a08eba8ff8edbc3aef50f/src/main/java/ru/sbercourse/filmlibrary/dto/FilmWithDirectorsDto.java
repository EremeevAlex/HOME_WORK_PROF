package homework_9.homework_filmlibrary;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FilmWithDirectorsDto extends FilmDto{

  private List<DirectorDto> directors;
}
