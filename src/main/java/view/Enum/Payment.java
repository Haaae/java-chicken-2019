package view.Enum;

import controller.ExceptionHandler;
import java.lang.ModuleLayer.Controller;
import java.util.Arrays;
import java.util.function.Consumer;

public enum Payment {

    CREDIT_CARD("1", Controller -> {}),
    CASH("2", Controller -> {});

    private final String symbol;
    private final Consumer<Controller> consumer;

    Payment(String symbol, Consumer<Controller> consumer) {
        this.symbol = symbol;
        this.consumer = consumer;
    }

    public static Payment from(String symbol) {
        return Arrays.stream(Payment.values())
                .filter(Payment -> Payment.getSymbol().equals(symbol))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(
                        "[ERROR] 결제 수단 선택은 '1' 혹은 '2'로 입력해주세요"));
    }

    public void process(Controller controller) {
        ExceptionHandler.process(consumer, controller);
    }

    public String getSymbol() {
        return symbol;
    }
}
