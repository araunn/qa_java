package ru.yandex.sprint6;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

import com.example.Feline;
import com.example.Lion;
import com.example.data.TestData;

@RunWith(Parameterized.class)
public class TestParametrizedLionGetKittens {
	private final String gender;
	private final Integer countKittens;
	
	@Parameterized.Parameters
	public static Object[][] testAnimalsParam() {
	   return new Object[][] {
	           {TestData.GENDER_LION,TestData.COUNT_KITTEN_LION},
	           {TestData.GENDER_LIONEES,TestData.COUNT_KITTEN_LIONESS},
	   };
	}  
	
    public TestParametrizedLionGetKittens(String gender, Integer countKittens) {
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
	public void testLionGetKittens() throws Exception{
	  Mockito.when(feline.getKittens(Mockito.anyInt())).thenReturn(countKittens);
	  Lion lion = new Lion(gender, feline);
	  assertEquals((int)countKittens,lion.getKittens());
	}

}
