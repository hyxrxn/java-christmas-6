package christmas;

public enum Menu {
    MUSHROOM_SOUP("양송이수프", 6000, "Appetizer"),
    TAPAS("타파스", 5500, "Appetizer"),
    CAESAR_SALAD("시저샐러드", 8000, "Appetizer"),

    T_BONE_STEAK("티본스테이크", 55000, "Main"),
    BARBECUE_RIBS("바비큐립", 54000, "Main"),
    SEAFOOD_PASTA("해산물파스타", 35000, "Main"),
    CHRISTMAS_PASTA("크리스마스파스타", 25000, "Main"),

    CHOCOLATE_CAKE("초코케이크", 15000, "Dessert"),
    ICE_CREAM("아이스크림", 5000, "Dessert"),

    ZERO_COLA("제로콜라", 3000, "Beverage"),
    RED_WINE("레드와인", 60000, "Beverage"),
    CHAMPAGNE("샴페인", 25000, "Beverage");

    private final String name;
    private final int price;
    private final String category;

    Menu(String name, int price, String category) {
        this.name = name;
        this.price = price;
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public String getCategory() {
        return category;
    }

    public static Menu findByName(String name) {
        for (Menu menu : Menu.values()) {
            if (menu.name.equals(name)) {
                return menu;
            }
        }
        return null;
    }
}
