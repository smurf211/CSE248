package model;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CreateFunctions {
	String capitals = "[A-Z]+";
	String numbers = "[0-9]+";
	String lowercase = "[a-z]+";
	String symbols = "[!\\\"#$%&'()*+,-./:;<=>?@[\\\\]^_`{|}~]+";
	Pattern patternCapitals = Pattern.compile(capitals);
	Pattern patternLowercase = Pattern.compile(lowercase);
	Pattern patternNumbers = Pattern.compile(numbers);
	Pattern patternSymbols = Pattern.compile(symbols);

	public boolean checkUserName(String userName, UserAccount[] array, int nElems) {

		for (int i = 0; i < nElems; i++) {

			if (userName.toLowerCase().equals(array[i].getUserName().toLowerCase())) {
				return false;
			}

		}

		return true;

	}

	public boolean checkPassword(String password) {

		Matcher matcherCapitals = patternCapitals.matcher(password);
		Matcher matcherLowercase = patternLowercase.matcher(password);
		Matcher matcherNumbers = patternNumbers.matcher(password);
		Matcher matcherSymbols = patternSymbols.matcher(password);

		if (matcherCapitals.find() && matcherLowercase.find() && matcherNumbers.find() && matcherSymbols.find()) {

			return true;

		}

		return false;

	}

	public boolean login(String username, String password, UserAccount[] array, int nElems) {

		for (int i = 0; i < nElems; i++) {

			if (username.toLowerCase().equals(array[i].getUserName().toLowerCase())) {

				if (password.equals(array[i].getPassword())) {

					return true;
				}

			}

		}
		return false;

	}

}
