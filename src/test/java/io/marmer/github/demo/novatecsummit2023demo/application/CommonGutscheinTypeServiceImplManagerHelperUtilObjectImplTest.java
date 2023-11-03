package io.marmer.github.demo.novatecsummit2023demo.application;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

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
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class CommonGutscheinTypeServiceImplManagerHelperUtilObjectImplTest {

  @InjectMocks
  private CommonGutscheinTypeServiceImplManagerHelperUtilObjectImpl underTest;

  private LocalDate now = LocalDate.now();

  @SneakyThrows //  tag::perMethod[]
  @Test
  void perMethodExample() {
    // Arrange
    var gutschein = new KitaGutschein()
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
        //... many more

    // Act
    var result = underTest.gebeVertragKitaGutscheinFrei(gutschein);

    // Assertion
    assertEquals(result.getFreigegebenAm(), now, "freigegebenAm");
  }
//  end::perMethod[]

  @SneakyThrows //  tag::mocked[]
  @Test
  void mockExampleSimple() {
    // Arrange
    var gutschein = mock(KitaGutschein.class);
    when(gutschein.getFreigegebenAm()).thenReturn(null);
    when(gutschein.getBetreuungsumfang()).thenReturn(Betreuungsumfang.GANZTAGS);

    // Act
    var result = underTest.gebeVertragKitaGutscheinFrei(gutschein);

    // Assertion
    verify(gutschein).setFreigegebenAm(now);
  }
//  end::mocked[]

}
