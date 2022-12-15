package view.Enum;

import controller.Controller;
import controller.ExceptionHandler;
import java.util.Arrays;
import java.util.function.Consumer;

public enum Menu {

    TAKING_ORDER("1", "주문등록", Controller -> {}),
    PAYMENT("2", "결제하기", Controller -> {}),
    QUIT("3", "프로그램 종료", Controller -> {});

    private final String symbol;
    private final String name;
    private final Consumer<Controller> consumer;

    Menu(String symbol, String name, Consumer<Controller> consumer) {
        this.symbol = symbol;
        this.name = name;
        this.consumer = consumer;
    }

    public static Menu from(String symbol) {
        return Arrays.stream(Menu.values())
                .filter(Menu -> Menu.getSymbol().equals(symbol))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("[ERROR] "));
    }

    public void process(Controller controller) {
        ExceptionHandler.process(consumer, controller);
    }

    public String getName() {
        return name;
    }

    public String getSymbol() {
        return symbol;
    }
}