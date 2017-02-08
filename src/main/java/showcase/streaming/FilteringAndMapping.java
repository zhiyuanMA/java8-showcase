package showcase.streaming;

import showcase.Item;
import showcase.Parcel;
import showcase.Person;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by zhiyuan on 2017/1/21.
 */
public class FilteringAndMapping {
    /**
     * Extract a list of names (firstname and lastname separated by a point) from a given list of Person objects.
     */
    public static List<String> extractNames(List<Person> persons) {
        return persons.stream().map(p -> p.getFirstName() + "·" + p.getLastName()).collect(Collectors.toList());
    }

    /**
     * Extract a sorted (ascending by lastname) list of names (firstname and lastname separated by a point) from a given list of Person objects.
     */
    public static List<String> extractNamesSortedByLastname(List<Person> persons) {
        return persons.stream().sorted((Person p1, Person p2) -> (p1.getLastName().compareTo(p2.getLastName())))
                .map(p -> p.getFirstName() + "·" + p.getLastName()).collect(Collectors.toList());
    }

    /**
     * From a given list of Person objects, extract a list of female firstnames
     */
    public static List<String> extractFemaleFirstName(List<Person> persons) {
        return persons.stream().filter(p -> p.getGender().equals(Person.Gender.FEMALE))
                .map(Person::getFirstName).collect(Collectors.toList());
    }

    /**
     * Extract all females older than 18 years from a given list of Person objects.
     */
    public static List<Person> extractWomen(List<Person> persons) {
        return persons.stream().filter(p -> p.getGender().equals(Person.Gender.FEMALE))
                .filter(p -> Period.between(p.getBirthDay(), LocalDate.now()).getYears() >= 18).collect(Collectors.toList());
    }

    /**
     * From a given list of parcels, extract a set of all item names.
     */
    public static Set<String> extractAllItemNames(List<Parcel> parcels) {
        return parcels.stream().<Item>flatMap(parcel -> parcel.getItems().stream())
                .<String>map(i -> i.getName()).collect(Collectors.toSet());
    }
}
