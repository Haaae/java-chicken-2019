package view.Enum;

import controller.Controller;
import controller.ExceptionHandler;
import java.util.Arrays;
import java.util.function.Consumer;

public enum MainScreen {

    TAKING_ORDER("1", "주문등록", Controller::takeOrder),
    PAYMENT("2", "결제하기", Controller::pay),
    QUIT("3", "프로그램 종료", Controller -> {});

    private final String symbol;
    private final String name;
    private final Consumer<Controller> consumer;

    MainScreen(String symbol, String name, Consumer<Controller> consumer) {
        this.symbol = symbol;
        this.name = name;
        this.consumer = consumer;
    }

    public static MainScreen from(String symbol) {
        return Arrays.stream(MainScreen.values())
                .filter(MainScreen -> MainScreen.getSymbol().equals(symbol))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("[ERROR] 올바르지 않은 입력입니다."));
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

    public boolean isQuit() {
        return this == QUIT;
    }
}