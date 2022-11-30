package com.example;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class CatTest {

    @Mock
    Feline feline;




    @Test
    public void getSound() {
        Cat cat = new Cat(feline);
        Assert.assertEquals("Мяу",cat.getSound());

    }

    @Test
    public void getFood() throws Exception {
        List<String>  expectedCatFood = List.of("Животные", "Птицы", "Рыба");
        Mockito.when(feline.eatMeat()).thenReturn(expectedCatFood);
        Cat cat = new Cat(feline);
        List<String>  actualCatFood = cat.getFood();
        Assert.assertEquals(expectedCatFood,actualCatFood);

    }
}