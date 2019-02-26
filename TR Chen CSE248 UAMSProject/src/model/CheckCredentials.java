package model;

import java.util.HashMap;
import java.util.Map.Entry;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CheckCredentials {
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

	public boolean checkUserNameHash(String userName, HashMap<UserAccount, String> map) {

		if (map.containsValue(userName)) {

			return false;
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

	public boolean login(String userName, String password, HashMap<UserAccount, String> map) {

		UserAccount user = null;
		for (Entry<UserAccount, String> entry : map.entrySet()) {
			if (userName.toLowerCase().equals(entry.getValue())) {

				user = entry.getKey();
				break;
			}
		}

		if (user.getPassword().equals(password)) {
			return true;

		}

		return false;

	}

}
