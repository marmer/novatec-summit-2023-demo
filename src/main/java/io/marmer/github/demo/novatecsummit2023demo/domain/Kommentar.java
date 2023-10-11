package io.marmer.github.demo.novatecsummit2023demo.domain;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Data
public class Kommentar {

  String kommentar;
  LocalDateTime erstellungszeitpunkt;
}
