#미션

## 구현 기능 목록

---

### 비즈니스 로직

- []

#### 클래스

- 메뉴
  - 메뉴 번호
  - 종류
  - 이름
  - 가격
- 테이블
  - 테이블 번호
  - 한 메뉴에 대한 최대 주문 수량 99개
  - 한 메뉴에 대한 현재 주문 수량
  - 주문 등록 상태 on/off
- 치킨 (interface)
  - 할인 기준 주문 숫자 = 10
  - 할인 기준 주문 숫자 당 할인 가격 = 10000
- 카운터
  - 현금 결제 시 할인율 = 5%
  - 주문 혹은 결제가 불가능한 경우 그 이유를 보여 주고, 다시 주문 혹은 결제가 가능하도록 해야 한다.
    - 최대 주문 수량 초과
    - 입력 오류
      - 유효하지 않은 숫자나 문자
  - 특정 테이블의 최종 결제 금액 계산 기능

### 뷰

#### Output

- [x] 메인화면 출력 - printMainScreen()
- [x] 원하는 기능 선택 알림 - printFunctionSelectionRequest()
- [x] 테이블 목록 - printTables(final List<Table> tables)
- [x] 테이블 선택 알림 - printTableSelectionRequest()
- [x] 메뉴판 출력 - public static void printMenus(final List<Menu> menus)
- [x] 등록할 메뉴 선택알림 - printMenuSelectionRequest()
- [] 테이블의 주문 내역 출력
- [] 특정 테이블 결제 진행 알림
- [x] 신용 카드 현금 선택 문구 출력 - printPaymentSelectionRequest()
- [] 최종 결제 금액 출력

#### Input

- [x] 테이블 숫자
- [x] 메인화면 기능 
- [x] 결제수단
- [x] 등록할 메뉴

### Controller

- []