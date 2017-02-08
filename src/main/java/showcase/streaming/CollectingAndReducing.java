package showcase.streaming;

import showcase.Item;
import showcase.Parcel;
import showcase.Person;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by zhiyuan on 2017/1/21.
 */
public class CollectingAndReducing {
    /**
     * Compute the average age of the given list of Persons.
     */
    public static Double averageAge(List<Person> persons) {
        return persons.stream()
                .mapToInt(Person::getAge)
                .average().getAsDouble();

    }

    /**
     * How old is the oldest person in the given list.
     */
    public static Integer maxAge(List<Person> persons) {
        return persons.stream()
                .mapToInt(Person::getAge)
                .max().getAsInt();
    }

    /**
     * Compute Age-Statistics (max, min, average, ...) for the given list of Persons.
     */
    public static IntSummaryStatistics ageStatistics(List<Person> persons) {
        return persons.stream()
                .mapToInt(Person::getAge)
                .summaryStatistics();
    }

    /**
     * Build a comma-separated list of the firstnames of a list of Persons.
     * <p/>
     * Example-Result: "Maggie, Marge, Mary"
     */
    public static String buildCommaSeparatedListOfFirstNames(List<Person> persons) {
        return persons.stream()
                .map(Person::getFirstName)
                .collect(Collectors.joining(", "));
    }

    /**
     * Identify the cheapest product (by unitPrice) in all invoices.
     */
    public static String cheapestProduct(List<Parcel> parcels) {
        return parcels.stream()
                .flatMap(invoice -> invoice.getItems().stream())
                .min(Comparator.comparing(Item::getUnitPrice))
                .get().getName();
    }

    /**
     * Identify the invoice with the highest total amount.
     */
    public static Parcel mostExpensiveInvoice(List<Parcel> parcels) {
        return parcels.stream()
                .collect(Collectors.<Parcel>maxBy(
                        Comparator.comparing(Parcel::getTotalCost))).get();
    }

    /**
     * Just what the method name says.
     */
    public static Map<Person, List<Parcel>> groupInvoicesByRecipient(List<Parcel> parcels) {
        return parcels.stream()
                .collect(Collectors.groupingBy(Parcel::getReceiver));
    }

    /**
     * Compute the total amount, that each receiver spent.
     * <p/>
     * Hint: Use the two-argument version of Collectors.groupingBy together with Collectors.mapping.
     */
    public static Map<Person, BigDecimal> expensesByRecipient(List<Parcel> parcels) {
        return parcels.stream()
                .collect(Collectors.groupingBy(
                        Parcel::getReceiver,
                        Collectors.mapping(
                                Parcel::getTotalCost,
                                Collectors.reducing(
                                        BigDecimal.ZERO,
                                        (sum, elem) -> sum.add(elem)))));
    }

    /**
     * How many items of each product have been purchased?
     */
    public static Map<String, Integer> countByProduct(List<Parcel> parcels) {
        return parcels.stream()
                .flatMap(invoice -> invoice.getItems().stream())
                .collect(Collectors.groupingBy(
                        Item::getName,
                        Collectors.summingInt(Item::getQuantity)));
    }
}
