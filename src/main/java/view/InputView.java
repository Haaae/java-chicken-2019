package view;

import domain.Menu;
import java.util.List;
import java.util.Scanner;
import view.Enum.MainScreen;
import view.Enum.Payment;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static int inputTableNumber() {
        OutputView.printTableSelectionRequest();
        String input = scanner.nextLine().trim();
        return InputValidator.numberValidate(input);
    }

    public static MainScreen inputMainFunctionNumber() {
        OutputView.printFunctionSelectionRequest();
        String input = scanner.nextLine().trim();
        return MainScreen.from(input);
    }

    public static Payment inputPaymentMethod() {
        OutputView.printPaymentSelectionRequest();
        String input = scanner.nextLine().trim();
        return Payment.from(input);
    }

    public static int inputMenuNumber(List<Menu> menus) {
        OutputView.printMenus(menus);
        String input = scanner.nextLine().trim();
        return InputValidator.numberValidate(input);
    }
}
