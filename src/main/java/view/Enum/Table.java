package view.Enum;

import controller.Controller;
import java.util.Arrays;
import java.util.function.Consumer;

public enum Table {

    ("1", "temp string", () -> {});

    private final String symbol;
    private final String name;
    private final Consumer<Controller> consumer;

    Table(String symbol, String name, Consumer<Controller> consumer) {
        this.symbol = symbol;
        this.name = name;
        this.consumer = consumer;
    }

    public static Table from(String symbol) {
        return Arrays.stream(Table.values())
                .filter(Table -> Table.getSymbol().equals(symbol))
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
