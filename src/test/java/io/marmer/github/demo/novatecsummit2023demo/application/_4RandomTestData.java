package io.marmer.github.demo.novatecsummit2023demo.application;

import io.marmer.github.demo.novatecsummit2023demo.domain.Betreuungsperson;
import io.marmer.github.demo.novatecsummit2023demo.domain.Betreuungsumfang;
import io.marmer.github.demo.novatecsummit2023demo.domain.Kind;
import io.marmer.github.demo.novatecsummit2023demo.domain.KitaGutschein;
import java.time.LocalDate;
import java.time.Month;
import java.util.List;

public class _4RandomTestData {
  //  tag::default[]
  // Default
  public static KitaGutschein newKitaGutschein() {
    return new KitaGutschein()
        .setGutscheinNummer("123")
        .setGutscheinName("Maxchen")
        .setFreigegebenAm(null)
        .setBetreuungsumfang(Betreuungsumfang.GANZTAGS)
        .setBetreuungsperson(List.of(new Betreuungsperson()
                .setVorname("Low")
                .setNachname("Power")
            // ...
        ))
        //...
        .setGutscheinName("Würstchen")
        .setKind(new Kind()
            .setVorname("Max")
            .setNachname("Power"));
    //...
  }
  //  end::default[]

  //  tag::custom[]
  // Custom
  public static KitaGutschein newKitaGutscheinFresh() {
    return new KitaGutschein()
        .setGutscheinNummer("123");
  }
  public static KitaGutschein newKitaGutscheinFreigegeben() {
    return newKitaGutschein()
        .setFreigegebenAm(LocalDate.of(2023, Month.NOVEMBER, 9));
  }
  public static KitaGutschein newKitaGutscheinWithLotsOfBetreuungsperson() {
    return newKitaGutschein()
        .setBetreuungsperson(List.of(/*...*/));
  }
  //  end::custom[]


}
