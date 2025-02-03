package christmas.view;

import christmas.constant.MenuEnum;
import christmas.model.Menu;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private final Scanner scanner = new Scanner(System.in);
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    public Date inputVisitDate() {
        while (true) {
            System.out.println("12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)");

            try {
                int date = Integer.parseInt(scanner.nextLine());
                validateDate(date);
                Date visitDate = dateFormat.parse("2025-12-" + String.format("%02d", date));
                return visitDate;

            } catch (NumberFormatException e) {
                System.out.println("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.");
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void validateDate(int date) {
        if (date < 1 || date > 31) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.");
        }
    }

    public List<Menu> inputOrder() {
        List<Menu> orderList = new ArrayList<>();
        System.out.println("주문하실 메뉴를 메뉴와 개수를 알려 주세요. (예시: 티본스테이크-1, 바비큐립-1, 초코케이크-2, 제로콜라-1)");

        String input = scanner.nextLine();  // 사용자 입력 받기
        String[] menuItems = input.split(",");  // 쉼표로 메뉴 항목 분리

        for (String item : menuItems) {
            String[] menuAndSize = item.split("-");  // 메뉴와 개수 분리
            if (menuAndSize.length != 2) {
                System.out.println("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
                return orderList;  // 잘못된 형식 처리
            }

            String menuName = menuAndSize[0].trim();
            int size;

            try {
                size = Integer.parseInt(menuAndSize[1].trim());  // 개수는 숫자로 변환
                MenuEnum menuEnum = MenuEnum.getMenuInfo(menuName);  // 메뉴 이름을 MenuEnum으로 찾기

                if (menuEnum != null && size > 0) {  // 유효한 메뉴와 개수일 경우
                    orderList.add(new Menu(menuEnum.getMenuName(), size));  // Menu 객체 생성하여 리스트에 추가
                } else {
                    System.out.println("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
                    return orderList;  // 잘못된 메뉴나 개수 처리
                }
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
                return orderList;  // 숫자 변환 실패 처리
            }
        }
        return orderList;  // 정상적으로 입력된 메뉴 리스트 반환
    }
}

