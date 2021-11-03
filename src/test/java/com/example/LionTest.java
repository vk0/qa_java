package com.example;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;


import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class LionTest {

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Mock
    Feline feline;
    //Feline feline = Mockito.mock(Feline.class);

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
        Lion lion = new Lion(checkedSexText, feline);
        boolean actual = lion.doesHaveMane();
        assertEquals(expected, actual);
    }

    @Test
    public void kittenLionTest() throws Exception {
        Lion lion = new Lion(checkedSexText, feline);
        Mockito.when(feline.getKittens()).thenReturn(1); // стаб
        int kittensCount = lion.getKittens();
        assertEquals(1, kittensCount);
    }

    @Test
    public void shouldGetFoodLionTest() throws Exception {
        Lion lion = new Lion(checkedSexText, feline);
        Mockito.when(feline.getFood("Хищник")).thenReturn(Arrays.asList("Животные", "Птицы", "Рыба")); // стаб
        List<String> actualList = lion.getFood();
        List<String> expectedList = Arrays.asList("Животные", "Птицы", "Рыба");
        assertEquals(expectedList, actualList);
    }
}
