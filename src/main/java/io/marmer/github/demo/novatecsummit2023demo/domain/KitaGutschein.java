package io.marmer.github.demo.novatecsummit2023demo.domain;

import java.time.LocalDate;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Data
public class KitaGutschein {
  String gutscheinNummer;
  String gutscheinName;
  Betreuungsumfang betreuungsumfang;
  LocalDate gueltigAb;
  LocalDate gueltigBis;
  LocalDate freigegebenAm;
  List<Kommentar> kommentare;
  List<KitaVertrag> kitaVertraege;
  List<Betreuungsperson> betreuungsperson;
  Kind kind;
}
