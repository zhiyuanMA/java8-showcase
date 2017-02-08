package showcase.streaming;

import org.hamcrest.MatcherAssert;
import org.junit.Test;
import showcase.Person;

import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.junit.Assert.assertThat;

/**
 * Created by zhiyuan on 2017/2/8.
 */
public class FilteringAndMappingTest extends StreamingTest {
    @Test
    public void testExtractNames() throws Exception {
        assertThat(FilteringAndMapping.extractNames(persons.subList(0, 6)),
                contains("Jane·Jungle", "Mary·Smith", "John·Dole", "Michael·Abrahams", "Chris·Cross", "Pete·Power"));
    }

    @Test
    public void testExtractNamesSortedByLastname() {
        assertThat(FilteringAndMapping.extractNamesSortedByLastname(persons.subList(0, 6)),
                contains("Michael·Abrahams", "Chris·Cross", "John·Dole", "Jane·Jungle", "Pete·Power", "Mary·Smith"));
    }

    @Test
    public void testExtractWomen() {
        assertThat(FilteringAndMapping.extractWomen(persons), contains(persons.get(0), persons.get(1)));
    }

    @Test
    public void testExtractFirstNamesOfFemales() throws Exception {
        assertThat(FilteringAndMapping.extractFemaleFirstName(persons), contains("Jane", "Mary", "Maggie"));
    }

    @Test
    public void testExtractAllProducts() throws Exception {
        MatcherAssert.assertThat(FilteringAndMapping.extractAllItemNames(parcels),
                containsInAnyOrder("Beer", "Burger", "Corn Flakes", "Chips", "Coke", "Cake", "Left-Handed Scissors"));
    }
}
