package io.marmer.github.demo.novatecsummit2023demo.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Data
public class Adresse {
  String strasse;
  String hausnummer;
  String plz;
  String ort;
  String land;
}
