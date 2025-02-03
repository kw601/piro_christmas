package christmas.controller;

import christmas.constant.BadgeEnum;
import christmas.model.Badge;
import christmas.model.EventPlannerModel;
import christmas.model.Menu;
import christmas.view.InputView;
import christmas.view.OutputView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class EventPlannerController {
    private final EventPlannerModel model;
    private final InputView inputView;
    private final OutputView outputView;
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    public  EventPlannerController() {
        this.model = new EventPlannerModel();
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    public void order() {
        outputView.printGreetings();

        // 방문 날짜
        Date visitDate = inputView.inputVisitDate();
        model.setVisitDate(visitDate);

        // 주문 메뉴
        List<Menu> orderedMenus = inputView.inputOrder();
        outputView.printOrderedMenu(orderedMenus);

        // 총 가격
        int beforeDiscountPrice = model.getBeforeDiscountPrice(orderedMenus);
        outputView.printBeforeDiscountPrice(beforeDiscountPrice);

        outputView.printEventGreetings();

        // 1. 총 가격이 이벤트 시작 가격(10,000)보다 적을 경우
        // -> 각 단계에서 처리함
        // 2. 증정 메뉴
        outputView.printGivingMenu(beforeDiscountPrice);
        // 3. 이벤트 계산
        // [혜택 내역]
            // 3-1. 크리스마스 디데이 할인
        int christmasDiscount = model.calculateChristmasDiscount();
            // 3-2. 평일 할인 / 주말 할인
        int weekdayDiscount = model.calculateWeekdayDiscount(orderedMenus);
        int weekendDiscount = model.calculateWeekendDiscount(orderedMenus);

        // 3-3. 특별 할인
        int specialDiscount = model.calculateSpecialDiscount();

        // 3-4. 증정 이벤트 -> before로 계산
        outputView.printBenefitList(christmasDiscount, weekdayDiscount, weekendDiscount, specialDiscount, beforeDiscountPrice);

        // 총 혜택 금액
        int totalDiscountPrice = christmasDiscount + weekdayDiscount + weekendDiscount + specialDiscount;
        outputView.printTotaBenefitPrice(totalDiscountPrice);

        // 총 결제 금액
        int totalPrice = beforeDiscountPrice - totalDiscountPrice;
        outputView.printTotalPrice(totalPrice);

        // 배지
        model.calculateBadge(totalPrice);
        Badge badge = model.getBadge();

        outputView.printBadge(badge);
    }


}
