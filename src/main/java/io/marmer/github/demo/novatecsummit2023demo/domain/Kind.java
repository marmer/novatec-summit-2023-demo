package io.marmer.github.demo.novatecsummit2023demo.domain;

import java.time.LocalDate;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Data
public class Kind {

  String vorname;
  String nachname;
  LocalDate geburtsdatum;
  List<Betreuungsperson> erziehungsberechtigte;
  Adresse wohnanschrift;
}
