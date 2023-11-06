package io.marmer.github.demo.novatecsummit2023demo.application;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import io.marmer.github.demo.novatecsummit2023demo.domain.Betreuungsperson;
import io.marmer.github.demo.novatecsummit2023demo.domain.Betreuungsumfang;
import io.marmer.github.demo.novatecsummit2023demo.domain.Kind;
import io.marmer.github.demo.novatecsummit2023demo.domain.KitaGutschein;
import java.time.LocalDate;
import java.util.List;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
//tag::perFileInit[]
class _2PerFileTest {

  private KitaGutschein gutscheinPrototype = new KitaGutschein()
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
//  end::perFileInit[]
  @InjectMocks
  private CommonGutscheinTypeServiceImplManagerHelperUtilObjectImpl underTest;

  private LocalDate now = LocalDate.now();

  //... many more

  @SneakyThrows
  //  tag::perFileChange[]
  @Test
  void perMethodExample() {
    // Arrange
    var gutschein = this.gutscheinPrototype
        .setFreigegebenAm(null)
        .setBetreuungsumfang(Betreuungsumfang.GANZTAGS);

    // Act
    var result = underTest.gebeVertragKitaGutscheinFrei(gutschein);

    // Assertion
    assertEquals(result.getFreigegebenAm(), now, "freigegebenAm");
  }
}
  //  end::perFileChange[]
