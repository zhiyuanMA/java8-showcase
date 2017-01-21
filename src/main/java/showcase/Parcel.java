package showcase;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by zhiyuan on 2017/1/21.
 */
public class Parcel {
    private final Person sender;
    private final Person receiver;
    private final List<Item> items;

    public Parcel(Person sender, Person receiver, List<Item> items) {
        this.sender = sender;
        this.receiver = receiver;
        this.items = items;
    }

    public BigDecimal getTotalCost() {
        return getItems().stream().<BigDecimal>map(i -> i.getUnitPrice().multiply(BigDecimal.valueOf(i.getQuantity()))).collect(Collectors.reducing(BigDecimal.ZERO, (sum, next) -> sum.add(next)));
    }

    public Person getSender() {
        return sender;
    }

    public Person getReceiver() {
        return receiver;
    }

    public List<Item> getItems() {
        return items;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Parcel parcel = (Parcel) o;

        if (!sender.equals(parcel.sender)) return false;
        if (!receiver.equals(parcel.receiver)) return false;
        return items.equals(parcel.items);
    }

    @Override
    public int hashCode() {
        int result = sender.hashCode();
        result = 31 * result + receiver.hashCode();
        result = 31 * result + items.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Parcel{" +
                "sender=" + sender +
                ", receiver=" + receiver +
                ", items=" + items +
                '}';
    }
}
