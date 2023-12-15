package christmas;

public class EventPlanner {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private int date;
    private Order order;

    void play() {
        setup();
    }

    void setup() {
        date = inputView.readDate();
        order = new Order(inputView.readOrder());
    }
}
