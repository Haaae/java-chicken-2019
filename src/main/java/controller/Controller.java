package controller;

public class Controller {

  public void run() {
    Menu menu;
    do {
      menu = ExceptionHandler.input(InputView::readMenu);
      menu.process(this);
    } while (!menu.isQuit());
  }

  public void 기능_1() {
      // TODO: 기능 구현. 해당 함수는 Menu 열거형의 Consumer로 전달된다.
  }

  public void 기능_1_내부_예외발생_시_재시작_함수() {
    // TODO: 기능 구현. 해당 함수는 Menu 열거형이 아닌 다른 열거형의 Consumer로 전달된다.
  }

  public void 기능_1() {
    // TODO: 기능 구현
  }

  private void 기능_1을_위한_private함수() {
    // TODO: 기능 구현
  }
}
