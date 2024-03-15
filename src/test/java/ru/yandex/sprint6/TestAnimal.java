package ru.yandex.sprint6;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import com.example.Cat;
import com.example.Feline;
import com.example.Lion;
import com.example.data.TestData;

import org.mockito.Spy;

@RunWith(Parameterized.class)
public class TestAnimal {
	private final String gender;
	private final Integer countKittens;
	
	@Parameterized.Parameters
	public static Object[][] testAnimalsParam() {
	   return new Object[][] {
	           {TestData.GENDER_LION,TestData.COUNT_KITTEN_LION},
	           {TestData.GENDER_LIONEES,TestData.COUNT_KITTEN_LIONESS},
	   };
	}  
	
    public TestAnimal(String gender, Integer countKittens) {
		this.gender = gender;
		this.countKittens = countKittens;
	}

	@Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }
	
    @Spy
       Feline feline;

	@Test
	public void testCatSound() {
	  Cat cat = new Cat(feline);
	  assertEquals(TestData.CAT_SOUND, cat.getSound());
	}
	
	@Test
	public void testCatGetFood() throws Exception {
	  Cat cat = new Cat(feline);
	  assertEquals(TestData.PREDATOR_FOODS, cat.getFood());
	}
	
	
	@Test
	public void testLionGetFood() throws Exception {
	  Lion lion = new Lion(TestData.GENDER_LION, feline);
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
	
	@Test
	public void testLionGetKittens() throws Exception{
	  Mockito.when(feline.getKittens(Mockito.anyInt())).thenReturn(countKittens);
	  Lion lion = new Lion(gender, feline);
	  assertEquals((int)countKittens,lion.getKittens());
	}
	
	@Test
	public void testFelineGetName() {
	  assertEquals(TestData.FELINE_NAME, feline.getFamily());
	}

}
