package christmas;

import java.util.ArrayList;
import java.util.List;

public class Validator {
    void checkDate(String date) {
        checkNaturalNumber(date, "날짜");
        checkDayOfMonth(date, "날짜");
    }

    private void checkNaturalNumber(String input, String what) {
        checkInteger(input, what);
        int modifiedInput = Integer.parseInt(input);
        if (modifiedInput < 1) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 " + what + "입니다. 다시 입력해 주세요.");
        }

    }

    private void checkInteger(String input, String what) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 " + what + "입니다. 다시 입력해 주세요.");        }

    }

    private void checkDayOfMonth(String input, String what) {
        int modifiedInput = Integer.parseInt(input);
        if (modifiedInput > 31) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 " + what + "입니다. 다시 입력해 주세요.");
        }
    }

    void checkOrder(String orders) {
        String[] parsedOrders = orders.split(",");
        List<String> menus = new ArrayList<>();
        int totalCount = 0;
        for (String string : parsedOrders) {
            String[] menuAndCount = string.split("-");
            checkCountOfStringArray(menuAndCount, "주문");
            checkExistMenu(menuAndCount[0], "주문");
            checkListContainMenu(menuAndCount[0], "주문", menus);
            menus.add(menuAndCount[0]);
            checkNaturalNumber(menuAndCount[1], "주문");
            checkTotalCount(menuAndCount[1], "주문", totalCount);
            totalCount += Integer.parseInt(menuAndCount[1]);
        }
    }

    private void checkCountOfStringArray(String[] input, String what) {
        if (input.length != 2) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 " + what + "입니다. 다시 입력해 주세요.");
        }
    }

    private void checkExistMenu(String input, String what) {
        if (Menu.findByName(input) == null) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 " + what + "입니다. 다시 입력해 주세요.");
        }
    }

    private void checkListContainMenu(String input, String what, List<String> menus) {
        if (menus.contains(input)) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 " + what + "입니다. 다시 입력해 주세요.");
        }
    }

    private void checkTotalCount(String input, String what, int totalCount) {
        if (totalCount + Integer.parseInt(input) > 20) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 " + what + "입니다. 다시 입력해 주세요.");
        }
    }
}
