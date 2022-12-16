package view.Enum;

import controller.ExceptionHandler;
import java.lang.ModuleLayer.Controller;
import java.util.Arrays;
import java.util.function.Consumer;

public enum Payment {

    CREDIT_CARD("1", 1),
    CASH("2", 0.95);

    private final String symbol;
    private final double discountRate;

    Payment(String symbol, double discountRate) {
        this.symbol = symbol;
        this.discountRate = discountRate;
    }

    public static Payment from(String symbol) {
        return Arrays.stream(Payment.values())
                .filter(Payment -> Payment.getSymbol().equals(symbol))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(
                        "[ERROR] 결제 수단 선택은 '1' 혹은 '2'로 입력해주세요"));
    }

    public String getSymbol() {
        return symbol;
    }

    public double getDiscountRate() {
        return discountRate;
    }
}
