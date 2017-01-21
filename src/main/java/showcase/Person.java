package showcase;

import java.time.LocalDate;
import java.time.Period;

/**
 * Created by zhiyuan on 2017/1/21.
 */
public class Person {

    public enum Gender {
        MALE, FEMALE
    }

    private final String firstName;
    private final String lastName;
    private final LocalDate birthDay;
    private final Gender gender;

    public Person(String firstName, String lastName, LocalDate birthDay, Gender gender) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDay = birthDay;
        this.gender = gender;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public LocalDate getBirthDay() {
        return birthDay;
    }

    public Gender getGender() {
        return gender;
    }

    public int getAge() {
        return Period.between(getBirthDay(), LocalDate.now()).getYears();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Person person = (Person) o;

        if (!firstName.equals(person.firstName)) return false;
        if (!lastName.equals(person.lastName)) return false;
        if (!birthDay.equals(person.birthDay)) return false;
        return gender == person.gender;
    }

    @Override
    public int hashCode() {
        int result = firstName.hashCode();
        result = 31 * result + lastName.hashCode();
        result = 31 * result + birthDay.hashCode();
        result = 31 * result + gender.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", birthDay=" + birthDay +
                ", gender=" + gender +
                '}';
    }
}
