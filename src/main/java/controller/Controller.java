package controller;

import domain.MenuRepository;
import domain.Table;
import domain.TableRepository;
import view.Enum.MainScreen;
import view.Enum.Payment;
import view.InputView;
import view.OutputView;

public class Controller {

    private final TableRepository tableRepository = new TableRepository();

    public void run() {
        MainScreen mainScreen;
        do {
            mainScreen = ExceptionHandler.input(InputView::inputMainFunctionNumber);
            mainScreen.process(this);
        } while (!mainScreen.isQuit());
    }

    public void takeOrder() {
        int tableNumber = ExceptionHandler.input(
                InputView::inputTableNumber, TableRepository.tables());
        int menuNumber = ExceptionHandler.input(
                InputView::inputMenuNumber, MenuRepository.menus());
        int menuQuantity = ExceptionHandler.input(InputView::inputMenuQuantity);

        tableRepository.takeOrder(tableNumber, menuNumber, menuQuantity);
    }

    public void pay() {
        int tableNumber = ExceptionHandler.input(
                InputView::inputTableNumber, TableRepository.tables());
        OutputView.printOrderHistory(tableRepository.getOrderHistory(tableNumber));
        Payment payment = ExceptionHandler.input(
                InputView::inputPaymentMethod, tableNumber);
        int amountOfPayment = tableRepository.amountOfPayment(tableNumber);
        OutputView.printAmountOfPayment((amountOfPayment * payment.getDiscountRate()));
    }
}
