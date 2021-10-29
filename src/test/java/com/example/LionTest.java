package com.example;

import com.example.Lion;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class LionTest {

    private final String checkedSexText;
    private final boolean expected;

    public LionTest(String checkedText, boolean expected) {
        this.checkedSexText = checkedText;
        this.expected = expected;
    }

    @Parameterized.Parameters // добавили аннотацию
    public static Object[][] getMane() {
        return new Object[][] {
                {"Самец", true},
                {"Самка", false},
        };
    }

    @Test
    public void shouldCheckMane() throws Exception {
        Lion lion = new Lion(checkedSexText);
        boolean actual = lion.doesHaveMane();
        assertEquals(expected, actual);
    }

    @Test
    public void kittenLionTest() throws Exception {
        Lion lion = new Lion("Самка");
        int kittensCount = lion.getKittens();
        assertEquals(1, kittensCount);
    }

}
