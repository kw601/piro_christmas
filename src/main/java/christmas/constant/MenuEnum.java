package christmas.constant;

public enum MenuEnum {
    MUSHROOM_SOUP("양송이수프", 6000, "APPETIZER"),
    TAPAS("타파스", 5500, "APPETIZER"),
    CAESAR_SALAD("시저샐러드", 8000, "APPETIZER"),
    CHOCOLATE_CAKE("초코케이크", 15000, "DESSERT"),
    ICE_CREAM("아이스크림", 5000, "DESSERT"),
    ZERO_COLA("제로콜라",3000, "DRINK"),
    RED_WINE("레드와인",60000, "DRINK"),
    CHAMPAGNE("샴페인",25000, "DRINK"),
    TBONE_STEAK("티본스테이크", 55000, "MAIN"),
    BBQ_RIBS("바비큐립", 54000, "MAIN"),
    SEAFOOD_PASTA("해산물파스타", 35000, "MAIN"),
    CHRISTMAS_PASTA("크리스마스파스타", 25000, "MAIN");


    private final String name;
    private final int price;
    private final String kind;

    MenuEnum(String name, int price, String kind) {
        this.name = name;
        this.price = price;
        this.kind = kind;
    }

    public String getMenuName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public String getMenuKind() {return kind;}

    public static MenuEnum getMenuInfo(String testValue) {
        for (MenuEnum menu : MenuEnum.values()) {
            if (menu.getMenuName().equalsIgnoreCase(testValue)) {
                return menu;
            }
        }
        return null;
    }
}
