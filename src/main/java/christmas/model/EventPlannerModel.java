package christmas.model;

import christmas.constant.BadgeEnum;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class EventPlannerModel {
    private Date visitDate;
    private final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    private Badge badge;

    public void setVisitDate(Date visitDate) {
        this.visitDate = visitDate;
    }

    public Date getVisitDate() {
        return visitDate;
    }

    public int getBeforeDiscountPrice(List<Menu> menuList) {
        return menuList.stream().mapToInt(Menu::getPrice).sum();
    }

    public int calculateChristmasDiscount() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(visitDate);
        int visitDay = calendar.get(Calendar.DAY_OF_MONTH);

        // 크리스마스 전까지만 시행
        if (visitDay > 25) { return 0; }

        // 12월 1일에 1000원 시작, 매일 100원씩 증가
        return 1000 + (visitDay - 1) * 100;
    }

    public int calculateWeekdayDiscount(List<Menu> menuList) {
        if (isWeekday()) {
            int dessertCount = countMenuByKind(menuList, "DESSERT");
            return 2023 * dessertCount;  // 디저트 메뉴 1개당 2023원 할인
        }
        return 0;
    }

    public int calculateWeekendDiscount(List<Menu> menuList) {
        if (isWeekend()) {
            int mainMenuCount = countMenuByKind(menuList, "MAIN");
            return 2023 * mainMenuCount;  // 메인 메뉴 1개당 2023원 할인
        }
        return 0;
    }

    public int calculateSpecialDiscount() {
        if (isStarDay()) {
            return 1000;  // 1000원 할인
        }
        return 0;
    }

    // 금, 토요일
    private boolean isWeekend() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(visitDate);
        int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
        return (dayOfWeek == Calendar.SATURDAY || dayOfWeek == Calendar.FRIDAY);
    }

    private boolean isWeekday() {
        return !isWeekend();
    }

    // 별 붙은 날 확인
    private boolean isStarDay() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(visitDate);
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);

        return (dayOfWeek == Calendar.SUNDAY || day == 25);  // 25일 또는 일요일
    }

    private int countMenuByKind(List<Menu> menuList, String kind) {
        int count = 0;
        for (Menu menu : menuList) {
            if (menu.getMenuKind().equals(kind)) {
                count++;
            }
        }
        return count;
    }

    public void calculateBadge(int totalPrice){
        this.badge = new Badge(totalPrice);
    }

    public Badge getBadge() { return badge; }

}
