package com.example;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.assertThrows;
import static org.mockito.Mockito.when;

@RunWith(Parameterized.class)
public class LionTest {

    public  String gender;
    public  boolean expectedResult;

    @Mock
    Feline feline;

    @Parameterized.Parameters (name = "gender = {0}, expectedResult = {1}")
    public static Object[][] getLionGender() {
        return new Object[][]{
                {"Самец",true},
                {"Самка",false},
        };
    }

    @Before
    public void init(){
        MockitoAnnotations.openMocks(this);
    }


    public LionTest(String gender, boolean expectedResult){
        this.gender = gender;
        this.expectedResult = expectedResult;

    }

    @Test
    public void getKittens() throws Exception {
        when(feline.getKittens()).thenReturn(1);
        Lion lion = new Lion(gender, feline);
        Assert.assertEquals(1,lion.getKittens());
    }

    @Test
    public void doesHaveManeThrowException()  {
        assertThrows(Exception.class, () ->  new Lion("львенок", feline));
    }

    @Test
    public void doesHaveMane() throws Exception {
        Lion lion = new Lion(gender, feline);
        Assert.assertEquals(expectedResult,lion.hasMane);

    }

    @Test
    public void getFood() throws Exception {
        when(feline.getFood("Хищник")).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        Lion lion = new Lion(gender, feline);
        Assert.assertEquals(List.of("Животные", "Птицы", "Рыба"),lion.getFood());
    }
}