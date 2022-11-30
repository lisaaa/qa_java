package com.example;


import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.junit.Assert.assertThrows;



public class LionNonParamTest {

    @Mock
    Feline feline;

    @Before
    public void init(){
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void doesHaveManeThrowException()  {
        assertThrows(Exception.class, () ->  new Lion("львенок", feline));
    }

}