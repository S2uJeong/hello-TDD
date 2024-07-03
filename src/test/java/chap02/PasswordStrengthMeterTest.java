package chap02;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PasswordStrengthMeterTest {
    PasswordStrengthMeter meter = new PasswordStrengthMeter();

    // 입력된 string 비밀번호의 강도를 구하고 그 값이 예상값 파라미터와 같은지 비교
    private void assertStrength(String password, PasswordStrength expStr) {
        PasswordStrength result = meter.meter(password);
        assertEquals(expStr, result);
    }
    @Test
    @DisplayName("모든 조건을 만족하면 비밀번호 강도는 강함이다.")
    void test1() {
        assertStrength("abc1@Add", PasswordStrength.STRONG);
        assertStrength("abc1!Add", PasswordStrength.STRONG);

    }
    @Test
    @DisplayName("길이가 8글자 미만이고 나머지 조건은 충족하는 경우 강도는 보통이다.")
    void test2() {
        assertStrength("ab12@!A", PasswordStrength.NORMAL);
    }

    @Test
    @DisplayName("숫자를 포함하지 않고 나머지 조건은 충족하는 경우 강도는 보통이다.")
    void test3() {
        assertStrength("abdfsd@!A", PasswordStrength.NORMAL);
    }
}
