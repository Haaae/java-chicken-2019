package domain;

public enum Category {
    CHICKEN("치킨", 10_000),
    BEVERAGE("음료", 0);

    private final String name;
    private final int discountPrice;

    Category(final String name, final int discountPricePerTen) {
        this.name = name;
        this.discountPrice = discountPricePerTen;
    }

    @Override
    public String toString() {
        return "[" + name + "]";
    }

    public int getDiscountPrice() {
        return discountPrice;
    }
}
