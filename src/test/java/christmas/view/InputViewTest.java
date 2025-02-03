package christmas.view;

import christmas.model.Menu;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

public class InputViewTest {
    private InputView inputView;
    private Scanner scanner;

    @BeforeEach
    void setUp() {
        inputView = new InputView();
        scanner = new Scanner(System.in);
    }

    // 테스트용 입력 값을 시뮬레이션하는 메서드
    private void simulateUserInput(String input) {
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
    }

    @Test
    void 방문_날짜가_1에서_31_범위를_벗어나는_경우_예외_발생() {
        assertThrows(IllegalArgumentException.class, () -> {
            inputView.validateDate(0);
        }, "[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.");

        assertThrows(IllegalArgumentException.class, () -> {
            inputView.validateDate(32);
        }, "[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.");
    }

//    @Test
//    void 유효한_날짜_입력_테스트() {
//        // 입력 값이 25일일 때
//        simulateUserInput("25");
//        assertEquals(25, inputView.inputVisitDate());
//    }

    @Test
    void 메뉴_입력_성공() {
        // 테스트용 InputView 인스턴스
        InputView inputView = new InputView();

        // 테스트로 직접 입력 받는 부분을 mocking하거나 가짜 입력을 처리할 방법이 필요
        List<Menu> orderList = inputView.inputOrder();
        assertFalse(orderList.isEmpty());
        assertEquals("티본스테이크", orderList.get(0).getMenu().getMenuName());
        assertEquals(1, orderList.get(0).getSize());
    }

    @Test
    void 메뉴_입력_실패() {
        InputView inputView = new InputView();

        // 잘못된 메뉴 이름 입력
        List<Menu> orderList = inputView.inputOrder();
        assertTrue(orderList.isEmpty());

        // 잘못된 형식 입력 (예: "티본스테이크1")
        orderList = inputView.inputOrder();
        assertTrue(orderList.isEmpty());
    }
}

