package ru.geekbrains.examples.junit;

import org.junit.jupiter.api.*;

@Disabled
public class BeforeAfterExampleTest extends BaseExampleTest {

    @BeforeAll
    static void beforeAll1() {
        System.out.println("Child class before all");
    }

    @BeforeEach
    void setUp1() {
        System.out.println("Child class before each");
    }

    @Test
    public void test01() {
        System.out.println("test 1");
    }

    @Test
    public void test02() {
        System.out.println("test 2");
    }

    @AfterEach
    void tearDown1() {
        System.out.println("Child class after each");
    }

    @AfterAll
    static void afterAll1() {
        System.out.println("Child class after all");
    }
}
