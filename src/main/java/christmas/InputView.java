package christmas;

import camp.nextstep.edu.missionutils.Console;

import java.util.HashMap;
import java.util.Map;

public class InputView {
    private final Validator validator = new Validator();

    int readDate() {
        System.out.println("12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)");
        while (true) {
            try {
                String date = Console.readLine();
                validator.checkDate(date);
                return Integer.parseInt(date);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    Map<Menu, Integer> readOrder() {
        System.out.println("주문하실 메뉴와 개수를 알려 주세요. (e.g. 해산물파스타-2,레드와인-1,초코케이크-1)");
        while (true) {
            try {
                String orders = Console.readLine();
                validator.checkOrder(orders);
                return parseOrder(orders);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private Map<Menu, Integer> parseOrder(String orders) {
        Map<Menu, Integer> result = new HashMap<>();
        String[] parsedOrder = orders.split(",");
        for (String string : parsedOrder) {
            String[] menuAndCount = string.split("-");
            result.put(Menu.findByName(menuAndCount[0]), Integer.parseInt(menuAndCount[1]));
        }
        return result;
    }
}
