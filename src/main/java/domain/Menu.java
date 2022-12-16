package domain;

import java.util.ArrayList;
import java.util.List;

public class Menu {

    public final static int DISCOUNT_UNIT = 10;
    private final int number;
    private final String name;
    private final Category category;
    private final int price;

    public Menu(final int number, final String name, final Category category, final int price) {
        this.number = number;
        this.name = name;
        this.category = category;
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

    public Category getCategory() {
        return category;
    }

    @Override
    public String toString() {
        return category + " " + number + " - " + name + " : " + price + "원";
    }

    @Override
    public boolean equals(final Object other) {
        if (this == other) {
            return true;
        }

        if (other instanceof Menu) {
            Menu otherTable = (Menu) other;
            return this.number == otherTable.number;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(number) + name.hashCode() + category.hashCode() + Integer.hashCode(
                price);
    }
}
