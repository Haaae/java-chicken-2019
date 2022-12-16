package view;

import domain.Menu;
import domain.Table;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import view.Enum.MainScreen;

public class OutputView {

    private static final String TOP_LINE = "┌ ─ ┐";
    private static final String TABLE_FORMAT = "| %s |";
    private static final String BOTTOM_LINE = "└ ─ ┘";
    private static final String POUND_KEY = "##";
    private static final String TABLE_PAYMENT_NOTICE = "번 테이블의 결제를 진행합니다.";
    private static final String MENU_HEADLINE = "## 메인화면";
    private static final String ORDER_HISTORY_HEADLINE = "## 주문 내역";
    private static final String AMOUNT_OF_PAYMENT_HEADLINE = "## 최종 결제할 금액";
    private static final String WON = "원";
    private static final String MENU_QUANTITY_AMOUNT = "메뉴 수량 금액";
    private static final String FUNCTION_SELECTION_REQUEST_HEADLINE = "## 원하는 기능을 선택하세요.";
    private static final String TABLE_SELECTION_REQUEST_HEADLINE = "## 테이블을 선택하세요.";
    private static final String MENU_SELECTION_REQUEST_HEADLINE = "## 등록할 메뉴를 선택하세요.";
    private static final String MENU_QUANTITY_REQUEST_HEADLINE = "## 메뉴의 수량을 입력하세요.";
    private static final String PAYMENT_SELECTION_REQUEST_HEADLINE = "## 신용 카드는 1번, 현금은 2번";
    private static final String SPACE = " ";
    private static final String MAIN_SCREEN_BAR = SPACE + "-" + SPACE;

    // 최종 결제 금액 출력
    public static void printAmountOfPayment(double amountOfPayment) {
        System.out.println();
        System.out.println(AMOUNT_OF_PAYMENT_HEADLINE);
        System.out.println(Math.round(amountOfPayment) + WON);
    }

    // 특정 테이블 결제 진행 알림 - domain 구현 후
    public static void printTablePayment(int tableNumber) {
        System.out.println();
        System.out.println(POUND_KEY
                + SPACE
                + tableNumber
                + TABLE_PAYMENT_NOTICE);
    }

    // 테이블 주문 내역 출력 - domain 구현 후
    public static void printOrderHistory(final Map<Menu, Integer> orderHistory) {
        System.out.println();
        System.out.println(ORDER_HISTORY_HEADLINE);
        System.out.println(MENU_QUANTITY_AMOUNT);
        orderHistory.keySet()
                .forEach(menu -> System.out.println(menu + " "
                        + orderHistory.get(menu) + " "
                        + menu.getPrice() * orderHistory.get(menu)));
    }

    // 메인화면 출력
    public static void printMainScreen() {
        System.out.println();
        System.out.println(MENU_HEADLINE);

        for (MainScreen mainScreen : MainScreen.values()) {
            System.out.println(mainScreen.getSymbol()
                    + MAIN_SCREEN_BAR
                    + mainScreen.getName());
        }
    }

    // 주문 수량 요청
    public static void printMenuQuantityRequest() {
        System.out.println();
        System.out.println(MENU_QUANTITY_REQUEST_HEADLINE);
    }

    // 기능 선택 요청
    public static void printFunctionSelectionRequest() {
        System.out.println();
        System.out.println(FUNCTION_SELECTION_REQUEST_HEADLINE);
    }

    // 테이블 선택 요청
    public static void printTableSelectionRequest() {
        System.out.println();
        System.out.println(TABLE_SELECTION_REQUEST_HEADLINE);
    }

    // 등록(주문)할 메뉴 선택 요청
    public static void printMenuSelectionRequest() {
        System.out.println();
        System.out.println(MENU_SELECTION_REQUEST_HEADLINE);
    }

    // 신용 카드 현금 선택 문구 출력
    public static void printPaymentSelectionRequest() {
        System.out.println(PAYMENT_SELECTION_REQUEST_HEADLINE);
    }

    public static void printTables(final List<Table> tables) {
        System.out.println("## 테이블 목록");
        final int size = tables.size();
        printLine(TOP_LINE, size);
        printTableNumbers(tables);
        printLine(BOTTOM_LINE, size);
    }

    public static void printMenus(final List<Menu> menus) {
        System.out.println();
        for (final Menu menu : menus) {
            System.out.println(menu);
        }
    }

    private static void printLine(final String line, final int count) {
        for (int index = 0; index < count; index++) {
            System.out.print(line);
        }
        System.out.println();
    }

    private static void printTableNumbers(final List<Table> tables) {
        for (final Table table : tables) {
            System.out.printf(TABLE_FORMAT, table);
        }
        System.out.println();
    }
}
