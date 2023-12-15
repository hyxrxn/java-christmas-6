package christmas;

import java.util.Map;

public class Order {
    private final Map<Menu, Integer> orderedMenu;
    private Map<Menu, Integer> presentedMenu;

    Order(Map<Menu, Integer> orderedMenu) {
        this.orderedMenu = orderedMenu;
    }
}
