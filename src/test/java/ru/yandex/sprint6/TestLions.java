package ru.yandex.sprint6;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.example.Feline;
import com.example.Lion;
import com.example.data.TestData;

@RunWith(MockitoJUnitRunner.class)
public class TestLions {
	
    @Mock
    Feline feline;

	@Test
	public void testLionGetFood() throws Exception {
	  Lion lion = new Lion(TestData.GENDER_LION, feline);
	  Mockito.when(lion.getFood()).thenReturn(TestData.PREDATOR_FOODS);
	  assertEquals(TestData.PREDATOR_FOODS, lion.getFood());
	}
	
	@Test
	public void testLionHasMane() throws Exception{
	  Lion lion = new Lion(TestData.GENDER_LION, feline);
	  assertTrue(lion.doesHaveMane());
	}
	
	@Test
	public void testLionessHasMane() throws Exception{
	  Lion lion = new Lion(TestData.GENDER_LIONEES, feline);
	  assertFalse(lion.doesHaveMane());
	}
	
	@Test
	public void testLionWithoutGender(){
		Lion lion;
	try {
	 lion = new Lion(TestData.WITHOUT_GENDER_LION, feline);
	} catch (Exception exc) {		
		 assertEquals(TestData.GENDER_ANSWER_MESSAGE, exc.getMessage());	
	}
	}
}
