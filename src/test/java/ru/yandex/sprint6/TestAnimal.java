package ru.yandex.sprint6;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import com.example.Feline;
import com.example.data.TestData;

public class TestAnimal {

	@Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }
	
	@Mock
       Feline feline;
		
	@Test
	public void testFelineGetName() throws Exception {
	  Mockito.when(feline.getFamily()).thenReturn(TestData.FELINE_NAME);
	  assertEquals(TestData.FELINE_NAME, feline.getFamily());
	}
}
