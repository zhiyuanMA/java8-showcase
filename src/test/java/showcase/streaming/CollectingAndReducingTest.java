package showcase.streaming;

import org.junit.Test;
import showcase.Item;
import showcase.Parcel;
import showcase.Person;
import showcase.TestData;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;

import static junit.framework.Assert.assertNotNull;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.not;

/**
 * Created by zhiyuan on 2017/2/8.
 */
public class CollectingAndReducingTest extends StreamingTest {
    private List<Person> receivers = TestData.listOfReceivers();

    @Test
    public void testAverageAge() throws Exception {
        assertThat(
                CollectingAndReducing.averageAge(persons),
                closeTo(33.85D, 0.01));
    }

    @Test
    public void testMaxAge() throws Exception {
        assertThat(
                CollectingAndReducing.maxAge(persons),
                equalTo(50));
    }

    @Test
    public void testAgeStatistics() throws Exception {
        IntSummaryStatistics statistic = CollectingAndReducing.ageStatistics(persons);
        System.out.println(statistic);
        assertNotNull(statistic);
        assertThat(statistic.getAverage(), equalTo(33.857142857142854));
        assertThat(statistic.getCount(), equalTo(7l));
        assertThat(statistic.getMax(), equalTo(50));
        assertThat(statistic.getMin(), equalTo(4));
        assertThat(statistic.getSum(), equalTo(237l));
    }

    @Test
    public void testBuildCommaSeparatedListOfFirstNames() throws Exception {
        assertThat(
                CollectingAndReducing.buildCommaSeparatedListOfFirstNames(persons),
                equalTo("Jane, Mary, John, Michael, Chris, Pete, Maggie"));
    }

    @Test
    public void testCheapestProduct() throws Exception {
        assertThat(
                CollectingAndReducing.cheapestProduct(parcels),
                equalTo("Chips"));
    }

    @Test
    public void testMostExpensiveInvoice() throws Exception {
        assertThat(
                CollectingAndReducing.mostExpensiveInvoice(parcels),
                equalTo(parcels.get(2)));
    }

    @Test
    public void testGroupInvoicesByRecipient() throws Exception {
        Map<Person, List<Parcel>> parcelByReceiver =
                CollectingAndReducing.groupInvoicesByRecipient(parcels);
        assertThat(parcelByReceiver.keySet(), hasSize(receivers.size()));

        for (Person receiver : receivers) {
            for (Parcel parcel : parcels) {
                if (receiver.equals(parcel.getReceiver())) {
                    assertThat(parcelByReceiver.get(receiver),
                            hasItem(parcel));
                } else {
                    assertThat(parcelByReceiver.get(receiver),
                            not(hasItem(parcel)));
                }
            }
        }
    }

    @Test
    public void testExpensesByRecipient() throws Exception {
        Map<Person, BigDecimal> expencesByReceiver =
                CollectingAndReducing.expensesByRecipient(parcels);
        assertThat(expencesByReceiver.keySet(), hasSize(receivers.size()));
        for (Person receiver : receivers) {
            BigDecimal expenses = BigDecimal.ZERO;
            for (Parcel parcel : parcels) {
                if (receiver.equals(parcel.getReceiver())) {
                    expenses = expenses.add(parcel.getTotalCost());
                }
            }
            assertThat(expencesByReceiver.get(receiver), equalTo(expenses));
        }
    }

    @Test
    public void testCountByProduct() throws Exception {
        Map<String, Integer> expected = new HashMap<>();
        for (Parcel parcel : parcels) {
            for (Item item : parcel.getItems()) {
                String name = item.getName();
                if (expected.get(name) == null) {
                    expected.put(name, item.getQuantity());
                    continue;
                }
                expected.put(name, expected.get(name) + item.getQuantity());
            }
        }
        Map<String, Integer> actual = CollectingAndReducing.countByProduct(parcels);
        assertThat(actual.keySet(), hasSize(expected.size()));
        for (Map.Entry entry : expected.entrySet()) {
            assertThat(actual, hasEntry(entry.getKey(), entry.getValue()));
        }
    }
}
