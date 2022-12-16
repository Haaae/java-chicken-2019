package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TableRepository {

    private static final List<Table> tables = new ArrayList<>();

    static {
        tables.add(new Table(1));
        tables.add(new Table(2));
        tables.add(new Table(3));
        tables.add(new Table(5));
        tables.add(new Table(6));
        tables.add(new Table(8));
    }

    public static List<Table> tables() {
        return Collections.unmodifiableList(tables);
    }

    public void takeOrder(int tableNumber, int menuNumber, int menuQuantity) {
        findTable(tableNumber).takeOrder(menuNumber, menuQuantity);
    }

    public int amountOfPayment(int tableNumber) {
        return findTable(tableNumber).getAmountOfPayment();
    }

    public Map<Menu, Integer> getOrderHistory(int tableNumber) {
        return findTable(tableNumber).getOrderHistory();
    }

    private Table findTable(int tableNumber) {
        return tables.get(tables().indexOf(new Table(tableNumber)));
    }
}
