package controller;

import java.util.function.Consumer;
import java.util.function.Supplier;

public class ExceptionHandler {

    /**
     * @param supplier, 즉 예외를 발생시킬 수 있는 InputView 함수
     * @return 인자로 들어간 InputView 함수의 반환값을 반환
     * @param <T>
     */
    public static <T> T input(Supplier<T> supplier) {
        try {
            return supplier.get();
        } catch (IllegalArgumentException e) {
            printExceptionMessage(e);
            return input(supplier);
        }
    }

    /**
     *
     * @param consumer, 즉 예외를 발생시킬 수 있는 비즈니스(도메인) 로직의 함수
     * @param t, 비즈니스 함수가 필요로 하는 인자
     * @param <T> 이게 뭘까
     */
    public static <T> void process(Consumer<T> consumer, T t) {
        try {
            consumer.accept(t);
        } catch (IllegalArgumentException | IllegalStateException e) {
            printExceptionMessage(e);
            process(consumer, t);
        }
    }

    private static void printExceptionMessage(RuntimeException e) {
        System.out.println(e.getMessage());
    }
}
