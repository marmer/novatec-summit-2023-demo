package io.marmer.github.demo.novatecsummit2023demo.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Adresse {
  String strasse;
  String hausnummer;
  String plz;
  String ort;
  String land;
}
