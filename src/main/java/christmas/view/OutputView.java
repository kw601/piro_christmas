package christmas.view;

import christmas.model.Badge;
import christmas.model.Menu;

import java.util.List;

public class OutputView {
    private boolean gifted = false;
    public void printGreetings () {
        System.out.println("안녕하세요! 우테코 식당 12월 이벤트 플래너입니다.");
    }

    public void printOrderedMenu(List<Menu> menuList) {
        System.out.println("<주문 메뉴>");
        for (Menu menu : menuList) {
            System.out.println(menu.toString());
        }
    }

    public void printBeforeDiscountPrice(int beforeDiscountPrice){
        System.out.println("<할인 전 총주문 금액>");
        System.out.println(beforeDiscountPrice + "원");
    }

    public void printEventGreetings(){
        System.out.println("12월 3일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!");
    }


    public void printGivingMenu(int beforeDiscountPrice) {
        System.out.println("<증정 메뉴>");
        if (beforeDiscountPrice >= 120000) {
            System.out.println("샴페인 1개");
            gifted = true;
            return;
        }
        System.out.println("없음");
    }

    public void printBenefitList(int christmasDiscount, int weekdayDiscount, int weekendDiscount, int specialDiscount, int beforeDiscountPrice) {
        System.out.println("<혜택 내역>");
        boolean discounted = false;
        if (christmasDiscount > 0) {
            discounted = true;
            System.out.println("크리스마스 디데이 할인: -" + christmasDiscount + "원");
        }
        if (weekdayDiscount > 0) {
            discounted = true;

            System.out.println("평일 할인: -" + weekdayDiscount + "원");
        }
        if (weekendDiscount > 0) {
            discounted = true;
            System.out.println("주말 할인: -" + weekendDiscount + "원");
        }
        if (specialDiscount > 0) {
            discounted = true;
            System.out.println("특별 할인: -" + specialDiscount + "원");
        }
        if (beforeDiscountPrice > 120000) {
            discounted = true;
            System.out.println("증정 이벤트: -25,000원");
        }
        if (!discounted) {
            System.out.println("없음");
        }
    }
    public void printTotaBenefitPrice(int totalBenefitPrice) {
        System.out.println("<총혜택 금액>");
        if (totalBenefitPrice > 0) {
            System.out.println("-"+totalBenefitPrice+"원");
            return;
        }
        System.out.println("0원");
    }

    public void printTotalPrice(int totalPrice){
        System.out.println("<할인 후 예상 결제 금액>");
        System.out.println(totalPrice + "원");
    }

    public void printBadge(Badge badge){
        System.out.println("<12월 이벤트 배지>");
        System.out.println(badge.toString());
    }

}
