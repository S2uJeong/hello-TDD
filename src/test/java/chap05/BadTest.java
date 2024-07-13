package chap05;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * 테스트 메서드 간 실행 순서 의존과 필드를 공유한 나쁜 사례
 */
public class BadTest {
    private static String str = "공유_필드";

    @Test
    void test1() {
        str = "hello";
        assertEquals(str, "hello");
    }

    @Test
    void test2() {
        assertEquals(str, "공유_필드");  // 실패하게 된다.

    }

}
