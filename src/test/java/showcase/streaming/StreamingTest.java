package showcase.streaming;

import showcase.Parcel;
import showcase.Person;
import showcase.TestData;

import java.util.List;

/**
 * Created by Administrator on 2017/2/8.
 */
public abstract class StreamingTest {
    List<Person> persons = TestData.listOfPersons();
    List<Parcel> parcels = TestData.listOfParcels();
}
