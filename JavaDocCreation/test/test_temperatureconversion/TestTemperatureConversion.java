package test_temperatureconversion;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import temperature_conversion.TemperatureConversion;

class TestTemperatureConversion {

	@Test
	void testCelsiusToFahrenheit() {
		assertThrows(IllegalArgumentException.class, () -> {TemperatureConversion.celsiusToFahrenheit(-274);});
		assertEquals(32.0, TemperatureConversion.celsiusToFahrenheit(0));
	}

}
