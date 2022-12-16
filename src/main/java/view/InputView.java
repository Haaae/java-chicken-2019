package view;

import domain.Menu;
import domain.Table;
import java.util.List;
import java.util.Scanner;
import view.Enum.MainScreen;
import view.Enum.Payment;

public class InputView {

    private static final Scanner scanner = new Scanner(System.in);

    public static int inputTableNumber(List<Table> tables) {
        OutputView.printTables(tables);
        OutputView.printTableSelectionRequest();
        String input = scanner.nextLine().trim();
        return InputValidator.numberValidate(input);
    }

    public static MainScreen inputMainFunctionNumber() {
        OutputView.printMainScreen();
        OutputView.printFunctionSelectionRequest();
        String input = scanner.nextLine().trim();
        return MainScreen.from(input);
    }

    public static Payment inputPaymentMethod(int tableNumber) {
        OutputView.printTablePayment(tableNumber);
        OutputView.printPaymentSelectionRequest();
        String input = scanner.nextLine().trim();
        return Payment.from(input);
    }

    public static int inputMenuNumber(List<Menu> menus) {
        OutputView.printMenus(menus);
        OutputView.printMenuSelectionRequest();
        String input = scanner.nextLine().trim();
        return InputValidator.numberValidate(input);
    }

    public static int inputMenuQuantity() {
        OutputView.printMenuQuantityRequest();
        String input = scanner.nextLine().trim();
        return InputValidator.numberValidate(input);
    }
}
