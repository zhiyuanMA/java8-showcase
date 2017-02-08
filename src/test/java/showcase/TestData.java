package showcase;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

/**
 * Created by zhiyuan on 2017/2/7.
 */
public class TestData {

    public static List<Person> listOfPersons() {
        return Arrays.asList(
                new Person("Jane", "Jungle", LocalDate.of(1978, 12, 15), Person.Gender.FEMALE),
                new Person("Mary", "Smith", LocalDate.of(1980, 10, 19), Person.Gender.FEMALE),
                new Person("John", "Dole", LocalDate.of(1973, 5, 31), Person.Gender.MALE),
                new Person("Michael", "Abrahams", LocalDate.of(1967, 2, 1), Person.Gender.MALE),
                new Person("Chris", "Cross", LocalDate.of(1985, 8, 22), Person.Gender.MALE),
                new Person("Pete", "Power", LocalDate.of(1981, 3, 18), Person.Gender.MALE),
                new Person("Maggie", "Simpson", LocalDate.of(2012, 10, 18), Person.Gender.FEMALE)
        );
    }

    public static List<Person> listOfReceivers() {
        Person homer = new Person("Homer", "Smith", LocalDate.of(1980, 10, 19), Person.Gender.FEMALE);
        Person bart = new Person("Bart", "Dole", LocalDate.of(1973, 5, 31), Person.Gender.MALE);
        Person marge = new Person("Marge", "Power", LocalDate.of(1981, 3, 18), Person.Gender.MALE);
        return Arrays.asList(homer, bart, marge);
    }

    public static List<Parcel> listOfParcels() {
        Person crusty = new Person("Crusty", "Burger", LocalDate.of(1978, 12, 15), Person.Gender.FEMALE);
        Person homer = new Person("Homer", "Smith", LocalDate.of(1980, 10, 19), Person.Gender.FEMALE);
        Person bart = new Person("Bart", "Dole", LocalDate.of(1973, 5, 31), Person.Gender.MALE);
        Person moe = new Person("Moe", "Abrahams", LocalDate.of(1967, 2, 1), Person.Gender.MALE);
        Person kwik = new Person("Kwik", "Cross", LocalDate.of(1985, 8, 22), Person.Gender.MALE);
        Person marge = new Person("Marge", "Power", LocalDate.of(1981, 3, 18), Person.Gender.MALE);
        Person flander = new Person("Flander", "Simpson", LocalDate.of(2012, 10, 18), Person.Gender.FEMALE);
        return Arrays.asList(
                new Parcel(crusty, homer, Arrays.asList(
                        new Item("Burger", 5, BigDecimal.valueOf(5)),
                        new Item("Coke", 1, BigDecimal.valueOf(5)))),
                new Parcel(crusty, bart, Arrays.asList(
                        new Item("Coke", 1, BigDecimal.valueOf(5)))),
                new Parcel(moe, homer, Arrays.asList(
                        new Item("Beer", 13, BigDecimal.valueOf(1.5)),
                        new Item("Burger", 3, BigDecimal.valueOf(4.5)))),
                new Parcel(kwik, homer, Arrays.asList(
                        new Item("Beer", 9, BigDecimal.valueOf(0.9)),
                        new Item("Chips", 2, BigDecimal.valueOf(0.5)))),
                new Parcel(moe, marge, Arrays.asList(
                        new Item("Beer", 1, BigDecimal.valueOf(1.5)))),
                new Parcel(kwik, bart, Arrays.asList(
                        new Item("Coke", 2, BigDecimal.valueOf(2.5)),
                        new Item("Chips", 2, BigDecimal.valueOf(0.5)))),
                new Parcel(kwik, marge, Arrays.asList(
                        new Item("Cake", 2, BigDecimal.valueOf(3.4)),
                        new Item("Corn Flakes", 5, BigDecimal.valueOf(2.3)))),
                new Parcel(moe, homer, Arrays.asList(
                        new Item("Beer", 5, BigDecimal.valueOf(1.5)))),
                new Parcel(flander, marge, Arrays.asList(
                        new Item("Left-Handed Scissors", 1, BigDecimal.valueOf(10.0))))
        );
    }
}
