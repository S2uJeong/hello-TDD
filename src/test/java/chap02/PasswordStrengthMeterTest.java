package chap02;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PasswordStrengthMeterTest {
    PasswordStrengthMeter meter = new PasswordStrengthMeter();
    @Test
    @DisplayName("모든 조건을 만족하면 비밀번호 강도는 강함이다.")
    void test1() {

        PasswordStrength result = meter.meter("ab12!@AB");
        assertEquals(PasswordStrength.STRONG, result);
        PasswordStrength result2 = meter.meter("abc1@Add");
        assertEquals(PasswordStrength.STRONG, result2);
    }
    @Test
    @DisplayName("길이가 8글자 미만이고 나머지 조건은 충족하는 경우 강도는 보통이다.")
    void test2() {
        PasswordStrengthMeter meter = new PasswordStrengthMeter();
        PasswordStrength result = meter.meter("ab12@!A");
        assertEquals(PasswordStrength.NORMAL, result);
    }

    @Test
    @DisplayName("숫자를 포함하지 않고 나머지 조건은 충족하는 경우 강도는 보통이다.")
    void test3() {
        PasswordStrengthMeter meter = new PasswordStrengthMeter();
        PasswordStrength result = meter.meter("abdfsd@!A");
        assertEquals(PasswordStrength.NORMAL, result);
    }
}
