package ru.yandex.sprint6;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import com.example.Feline;
import com.example.data.TestData;

@RunWith(MockitoJUnitRunner.class)
public class TestFeline {
	
    @Spy
    Feline feline;

	@Test
	public void testFelineGetFamily() throws Exception {
	  feline.getFamily();
	  Mockito.verify(feline).getFamily();
	}
	
	@Test
	public void testFelineGetMeat() throws Exception {
	  feline.eatMeat();
	  Mockito.verify(feline).eatMeat();
	}
}

