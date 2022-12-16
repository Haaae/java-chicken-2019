package domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Table {
    private final int number;
    private final Map<Menu, Integer> orderHistory = new HashMap<>();
    private static final List<Integer> tableNumbers
            = new ArrayList<Integer>(List.of(1, 2, 3, 5, 6, 8));
    private final int MAXIMUM_ORDER_NUMBER_PER_MENU = 99;
    private final int MINIMUM_ORDER_NUMBER_PER_MENU = 0;

    public Table(final int number) {
        validate(number);
        this.number = number;
        initOrderedMenus();
    }

    public void takeOrder(final int menuNumber, final int menuQuantity) {
        MenuRepository.menus().stream()
                .filter(menu -> menu.getPrice() == menuNumber)
                .forEach(menu -> plusOrder(menu, menuQuantity));
    }

    public Map<Menu, Integer> getOrderHistory() {
        return orderHistory;
    }

    public int getAmountOfPayment() {
        int amountOfPayment = 0;
        for (Menu menu : orderHistory.keySet()) {
            // 수량 * 금액 - (수량 / 10 * 할인금액)
            int amount = orderHistory.get(menu);
            if (amount == 0) {
                continue;
            }
            amountOfPayment += amount * menu.getPrice()
                    - (amount / Menu.DISCOUNT_UNIT * menu.getCategory().getDiscountPrice());
        }
        return amountOfPayment;
    }

    @Override
    public String toString() {
        return Integer.toString(number);
    }

    @Override
    public boolean equals(final Object other) {
        if (this == other) {
            return true;
        }

        if (other instanceof Table) {
            Table otherTable = (Table) other;
            return this.number == otherTable.number;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(number)
                + Integer.hashCode(MAXIMUM_ORDER_NUMBER_PER_MENU)
                + Integer.hashCode(MINIMUM_ORDER_NUMBER_PER_MENU);
    }

    private void validate(int number) {
        if (!tableNumbers.contains(number)) {
            throw new IllegalArgumentException(
                    "[ERROR] 테이블 번호는 1, 2, 3, 5, 6, 8 중 하나여야 합니다.");
        }
    }

    private void initOrderedMenus() {
        MenuRepository.menus()
                .forEach(menu -> orderHistory.put(menu, MINIMUM_ORDER_NUMBER_PER_MENU));
    }


    private void plusOrder(final Menu menu, final int menuQuantity) {
        if (orderHistory.get(menu) + menuQuantity > MAXIMUM_ORDER_NUMBER_PER_MENU) {
            throw new IllegalStateException(""
                    + "[ERROR] 주문이 최대 수량을 초과했습니다. 주문 최대 수량은 테이블 당 99개입니다.");
        }
        orderHistory.replace(menu, menuQuantity);
    }
}
