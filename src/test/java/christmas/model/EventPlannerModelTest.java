package christmas.model;
import christmas.view.InputView;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class EventPlannerModelTest {

    private EventPlannerModel model;

    @BeforeEach
    void setUp() {
        model = new EventPlannerModel();
    }

//    @Test
//    void 방문_날짜_설정_테스트() {
//        EventPlannerModel model = new EventPlannerModel();
//        InputView inputView = new InputView();
//
//        Date testDate = inputView.inputVisitDate(25);  // 입력값을 "25"로 가정
//
//        model.setVisitDate(testDate);
//
//        assertEquals(testDate, model.getVisitDate());
//    }
}