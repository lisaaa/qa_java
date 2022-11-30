package com.example;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;


public class FelineTest {

    protected static final int COUNT_KITTENS = 1;
    protected static final String FELINE_FAMILY = "Кошачьи";
    Feline feline = new Feline();

    @Test
    public void eatMeat() throws Exception {
        List<String> actualEatMeat = feline.eatMeat();
        List<String> expectedEatMeat = List.of("Животные", "Птицы", "Рыба");
        Assert.assertTrue(actualEatMeat.containsAll(expectedEatMeat));
    }

    @Test
    public void getFamily() {
        String actualFamily = feline.getFamily();
        Assert.assertEquals(FELINE_FAMILY,actualFamily);
    }

    @Test
    public void getKittens() {
        int actualKittens = feline.getKittens();
        Assert.assertEquals(COUNT_KITTENS,actualKittens);
    }

    @Test
    public void GetKittensCount() {
        int actualCountKittens = feline.getKittens(COUNT_KITTENS);
        Assert.assertEquals(COUNT_KITTENS,actualCountKittens);
    }
}