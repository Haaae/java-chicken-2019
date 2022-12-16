package view;

import domain.Menu;
import domain.Table;

import java.util.List;
import view.Enum.MainScreen;

public class OutputView {
    private static final String TOP_LINE = "┌ ─ ┐";
    private static final String TABLE_FORMAT = "| %s |";
    private static final String BOTTOM_LINE = "└ ─ ┘";
    private static final String MENU_HEADLINE = "## 메인화면";
    private static final String FUNCTION_SELECTION_REQUEST_HEADLINE = "## 원하는 기능을 선택하세요.";
    private static final String TABLE_SELECTION_REQUEST_HEADLINE = "## 테이블을 선택하세요.";
    private static final String MENU_SELECTION_REQUEST_HEADLINE = "## 등록할 메뉴를 선택하세요.";
    private static final String PAYMENT_SELECTION_REQUEST_HEADLINE = "## 신용 카드는 1번, 현금은 2번";
    private static final String SPACE = " ";
    private static final String MAIN_SCREEN_BAR = SPACE + "-" + SPACE;

    // 테이블 주문 내역 출력 - domain 구현 후
    // 특정 테이블 결제 진행 알림 - domain 구현 후
    // 최종 결제 금액 출력

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
