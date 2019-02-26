package temperature_conversion;

/**
 * 
 * The TemperatureConversion Java application prints a table converting celsius
 * to fahrenheit degrees.
 * 
 * @see <A href="../src/temperature_conversion/TemperatureConversion.java">Java
 *      sourceCode</A>
 * 
 * 
 * @author Mike <A href="mailto:spadm98@sunysuffolk.edu">
 *         spadm98@sunysuffolk.edu </A>
 * 
 * @version v1.0, 2/19/2019
 * 
 */

public class TemperatureConversion {
	
	/**
	 *  The main method prints a celsius to fahrenheit conversion table
	 *  
	 *  The bounds of the table range from -50 to +50 celsius in 10 degree increments
	 *  
	 * @param args not used
	 * @author mike
	 */
	
	public static void main(String[] args) {
		
		final double TABLE_BEGIN = -50.0;
		final double TABLE_END = 50.0;
		
		final double TABLE_STEP = 10.0;
		
		double celsius;
		double fahrenheit;
		
		System.out.println("TEMPERATURE CONVERSION TABLE");
		System.out.println("----------------------------");
		System.out.println("Celsius        Fahrenehit");
		for(celsius = TABLE_BEGIN; celsius <=TABLE_END; celsius += TABLE_STEP) {
			fahrenheit = celsiusToFahrenheit(celsius);
			System.out.printf("%6.2fC", celsius);
			System.out.printf("%14.2fF\n", fahrenheit);
			System.out.println("-------------------------");
			
		}
				
		
		
		
	}
	
	
	/**
	 * Convert a tempertaure from Celsius degrees to Farenheit degrees
	 * 
	 * @param celsius: temperature in celsius degrees
	 * @return the temperature converted to fahrenheit
	 * @throws java.lang.IllegalArgumentException indicates that Celsius is less than the smallest Celsius temperature (-273.16)
	 * @mike.precondition celsius greater than or equal to -273.16
	 * @mike.postcondition temperature in Fahrenheit
	 */

	public static double celsiusToFahrenheit(double celsius) {
		final double MINIMUM_CELSIUS = -273.16;

		if (celsius < MINIMUM_CELSIUS) {

			throw new IllegalArgumentException("Argument " + celsius + " too low.");
		}

		return (9.0 / 5.0) * celsius + 32;
	}

}
