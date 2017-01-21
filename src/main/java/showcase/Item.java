package showcase;

import java.math.BigDecimal;

/**
 * Created by zhiyuan on 2017/1/21.
 */
public class Item {
    private final String name;
    private final int quantity;
    private final BigDecimal unitPrice;


    public Item(String name, int quantity, BigDecimal unitPrice) {
        this.name = name;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Item item = (Item) o;

        if (!name.equals(item.name)) return false;
        if (quantity != item.quantity) return false;
        return unitPrice.equals(item.unitPrice);
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + quantity;
        result = 31 * result + unitPrice.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Item{" +
                "name='" + name + '\'' +
                ", quantity='" + quantity + '\'' +
                ", unitPrice=" + unitPrice +
                '}';
    }
}
