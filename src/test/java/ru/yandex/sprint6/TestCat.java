package ru.yandex.sprint6;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.example.Cat;
import com.example.Feline;
import com.example.data.TestData;

@RunWith(MockitoJUnitRunner.class)
public class TestCat {

    @Mock
    Feline feline;

	@Test
	public void testCatSound() {
	  Cat cat = new Cat(feline);
	  assertEquals(TestData.CAT_SOUND, cat.getSound());
	}
	
	@Test
	public void testCatGetFood() throws Exception {
	  Cat cat = new Cat(feline);
	  Mockito.when(cat.getFood()).thenReturn(TestData.PREDATOR_FOODS);
	  assertEquals(TestData.PREDATOR_FOODS, cat.getFood());
	}

}
