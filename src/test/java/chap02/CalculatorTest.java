package chap02;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 *       - 메서드 이름
 *       - 파라미터 개수, 파라미터 타입, 반환 값
 *       - 정적/인스턴스 메서드
 *       - 메서드를 제공할 클래스의 이름
 */
public class CalculatorTest {
    @Test
    void plus() {
        int result = Calculator.plus(1,2);
        assertEquals(3,result);
    }
}
