package io.marmer.github.demo.novatecsummit2023demo.domain;

import java.time.LocalDate;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Data
public class KitaVertrag {

  String vertragsnummer;
  String vertragsname;
  LocalDate vertragsbeginn;
  LocalDate vertragsende;
  Betreuungsumfang betreuungsumfang;
  List<Kommentar> kommentare;

  List<Betreuungsperson> betreuungsperson;

  Einrichtung einrichtung;

  Traeger traeger;
}
