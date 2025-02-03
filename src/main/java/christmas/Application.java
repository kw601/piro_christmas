package christmas;

import christmas.controller.EventPlannerController;
import christmas.model.EventPlannerModel;

public class Application {
    public static void main(String[] args) {
        EventPlannerController controller = new EventPlannerController();
        controller.order();
    }
}
