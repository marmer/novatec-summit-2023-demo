package io.marmer.github.demo.novatecsummit2023demo.application;

import static org.junit.jupiter.api.Assertions.*;

import io.marmer.github.demo.novatecsummit2023demo.domain.Betreuungsperson;
import io.marmer.github.demo.novatecsummit2023demo.domain.Betreuungsumfang;
import io.marmer.github.demo.novatecsummit2023demo.domain.Kind;
import io.marmer.github.demo.novatecsummit2023demo.domain.KitaGutschein;
import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import lombok.SneakyThrows;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class CommonGutscheinTypeServiceImplManagerHelperUtilObjectImplTest {

  @InjectMocks
  private CommonGutscheinTypeServiceImplManagerHelperUtilObjectImpl underTest;

  private LocalDate now = LocalDate.now();

  @Test
  @DisplayName("SollteKitagutscheinFreigeben")
  @SneakyThrows
//  tag::perMethod[]
  void gebeVertragKitaGutscheinFrei_SollteKitagutscheinFreigeben() {
    // Arrange
    var gutschein = new KitaGutschein()
        .setGutscheinNummer("123")
        .setGutscheinName("Maxchen")
        .setFreigegebenAm(null)
        .setBetreuungsumfang(Betreuungsumfang.GANZTAGS)
            .setBetreuungsperson(List.of(new Betreuungsperson()
                .setNachname("Power")
                .setVorname("Low")
                // ...
            ))
        //...
        .setGutscheinName("Würstchen")
        .setKind(new Kind()
            .setVorname("Max")
            .setNachname("Power"));
        //... many more

    // Act
    var result = underTest.gebeVertragKitaGutscheinFrei(gutschein);

    // Assertion
    assertEquals(result.getFreigegebenAm(), now, "freigegebenAm");
  }
//  end::perMethod[]


//  tag::mockedTestdata[]
  //todo hier nen Beispiel mit gemockten Daten
//  end::mockedTestdata[]
}
