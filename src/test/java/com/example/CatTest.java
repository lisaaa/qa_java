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
        Mockito.when(feline.eatMeat()).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        Cat cat = new Cat(feline);
        List<String>  actualCatFood = cat.getFood();
        Assert.assertEquals(List.of("Животные", "Птицы", "Рыба"),actualCatFood);

    }
}