package chap05;

import org.junit.jupiter.api.*;

public class LifeCycleTest {
    public LifeCycleTest() {
        System.out.println("Test 객체 생성");
    }
    @BeforeAll
    static void beforeAllMethod() {
        System.out.println("모든 테스트에 대한 초기화 수행");
    }
    @BeforeEach
    void beforeEach() {
        System.out.println("각 메서드별로 전 단계에 실행됩니다.");
    }

    @Test
    void test1() {
        System.out.println("test1");
    }

    @Test
    void test2() {
        System.out.println("test2");
    }

    @AfterEach
    void afterEach() {
        System.out.println("각 메서드별로 후 단계에 실행됩니다.");
    }

    @AfterAll
    static void afterAll() {
        System.out.println("모든 테스트에 대한 마무리 수행");
    }
}
