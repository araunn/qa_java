package ru.yandex.sprint6;

import static org.junit.Assert.*;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import com.example.Cat;
import com.example.Feline;
import com.example.Lion;
import com.example.data.ParameteriazedTestData;

import org.mockito.Spy;

@RunWith(Parameterized.class)
public class TestAnimal {
	private final String gender;
	private final Integer countKittens;
	
	@Parameterized.Parameters
	public static Object[][] testAnimalsParam() {
	   return new Object[][] {
	           {ParameteriazedTestData.GENDER_LION,ParameteriazedTestData.COUNT_KITTEN_LION},
	           {ParameteriazedTestData.GENDER_LIONEES,ParameteriazedTestData.COUNT_KITTEN_LIONESS},
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
	  assertEquals("Мяу", cat.getSound());
	}
	
	@Test
	public void testCatGetFood() throws Exception {
	  Cat cat = new Cat(feline);
	  assertEquals(List.of("Животные", "Птицы", "Рыба"), cat.getFood());
	}
	
	
	@Test
	public void testLionGetFood() throws Exception {
	  Lion lion = new Lion("Самец", feline);
	  assertEquals(List.of("Животные", "Птицы", "Рыба"), lion.getFood());
	}
	
	@Test
	public void testLionHasMane() throws Exception{
	  Lion lion = new Lion("Самец", feline);
	  assertTrue(lion.doesHaveMane());
	}
	
	@Test
	public void testLionessHasMane() throws Exception{
	  Lion lion = new Lion("Самка", feline);
	  assertFalse(lion.doesHaveMane());
	}
	
	@Test
	public void testLionWithoutGender(){
		Lion lion;
	try {
	 lion = new Lion("Не определившийся лев", feline);
	} catch (Exception exc) {		
		 assertEquals("Используйте допустимые значения пола животного - самей или самка", exc.getMessage());	
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
	  assertEquals("Кошачьи", feline.getFamily());
	}

}
