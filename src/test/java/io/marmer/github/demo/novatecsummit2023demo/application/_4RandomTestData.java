package io.marmer.github.demo.novatecsummit2023demo.application;

import static org.instancio.Select.field;
import static org.instancio.Select.fields;
import static org.jeasy.random.FieldPredicates.isAnnotatedWith;
import static org.jeasy.random.FieldPredicates.named;
import static org.jeasy.random.FieldPredicates.ofType;

import com.github.javafaker.Faker;
import io.marmer.github.demo.novatecsummit2023demo.domain.Adresse;
import io.marmer.github.demo.novatecsummit2023demo.domain.Betreuungsperson;
import io.marmer.github.demo.novatecsummit2023demo.domain.Betreuungsumfang;
import io.marmer.github.demo.novatecsummit2023demo.domain.KitaGutschein;
import io.marmer.github.demo.novatecsummit2023demo.testdata.TestdatageneratorBase;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import org.instancio.Instancio;
import org.instancio.InstancioApi;
import org.instancio.Select;
import org.instancio.settings.Keys;
import org.instancio.settings.Settings;
import org.jeasy.random.EasyRandom;
import org.jeasy.random.EasyRandomParameters;

public class _4RandomTestData extends TestdatageneratorBase {


  //  tag::default[]
  // From KitaGutscheinTestdataProvider
  public KitaGutschein newKitaGutschein() {
    return new KitaGutschein()
        .setGutscheinNummer(nextString(5))
        .setBetreuungsumfang(nextEnumOf(Betreuungsumfang.class))
        .setGueltigAb(nextLocalDate()) //...
        .setBetreuungsperson(List.of(newBetreuungsperson())
        ) /* ... */;
  }

  // From BetreuungspersonTestdataProvider
  private Betreuungsperson newBetreuungsperson() {
    return new Betreuungsperson()
        .setNachname(nextString())
        .setVorname(nextString());
    //...
  }
  //  end::default[]

  //  tag::faker[]
  int seed = 42; // or test method names
  private Faker faker = Faker.instance(Locale.GERMANY, new Random(seed));

  private Betreuungsperson newReadableBetreuungsperson() {
    return new Betreuungsperson()
        .setNachname(faker.name().firstName())
        .setVorname(faker.name().lastName())
        .setWohnanschrift(newAdresse());
    //...
  }

  private Adresse newAdresse() {
    return newAdresse()
        .setHausnummer(faker.address().streetAddressNumber())
        .setLand(faker.address().country())
        .setOrt(faker.address().city())
        .setPlz(faker.address().zipCode())
        .setStrasse(faker.address().streetAddress());
  }
  //  end::faker[]

  //  tag::EasyRandom[]
  // Defaults
  EasyRandomParameters parameters = new EasyRandomParameters()
      .seed(123L)
      .objectPoolSize(100)
      .randomizationDepth(3)
      .charset(StandardCharsets.UTF_8)
      .stringLengthRange(5, 50)
      .collectionSizeRange(1, 10)
      .scanClasspathForConcreteTypes(true)
      .ignoreRandomizationErrors(true)
      // ...
      //by property name, property type, class, modifiers
      .excludeField(named("id"))
      .excludeField(isAnnotatedWith(Version.class)) // annotation
      .randomize(Adresse.class, () -> newAdresse()) // full type
      .randomize(named("name").and(ofType(String.class)), () -> faker.name().lastName())
      ;

  EasyRandom easyRandom = new EasyRandom(parameters);

  private KitaGutschein newUsefullGutschein(){
    return easyRandom.nextObject(KitaGutschein.class);
    // add more customization here...
  }
  //  end::EasyRandom[]

  //  tag::Instancio[]
  Settings settings = Settings.create()
      .set(Keys.COLLECTION_MIN_SIZE, 10)
      .set(Keys.STRING_ALLOW_EMPTY, true)
      .set(Keys.SEED, 42L)
      .lock();
  private KitaGutschein newInstancioGutschein(){
    return Instancio.of(KitaGutschein.class)
            .withSettings(settings)
            // .withSeed(42) // also possible here
            .set(fields().named("gutscheinNummer"), "foo")
            .ignore(fields().named("version").annotated(Version.class))
            .create();
  }
  //  end::Instancio[]


  @Retention(RetentionPolicy.RUNTIME)
  @Target(ElementType.FIELD)
  public @interface Version {
  }
}
