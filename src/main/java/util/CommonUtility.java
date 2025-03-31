package util;

import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;

import org.apache.commons.lang3.RandomStringUtils;

public class CommonUtility {

	public String generateRandomAplhaNumericString(int length) {
		return RandomStringUtils.randomAlphanumeric(length);
	}

	public String generateRandomEmailId() {
		String randomString = RandomStringUtils.randomAlphanumeric(8);
		return randomString + "@example.com";
	}

	public String generateRandomPassword(int length) {
		String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%^&*";
		Random random = new Random();
		StringBuilder password = new StringBuilder();

		for (int i = 0; i < length; i++) {
			password.append(chars.charAt(random.nextInt(chars.length())));
		}

		return password.toString();
	}

	public Map<String, String> mapWithaValues(Map<String, String> map) {
		return map.entrySet().stream().filter(entry -> entry.getValue() != null).collect(Collectors.toMap(
				Map.Entry::getKey,
				entry -> TestVariables.map.containsKey(entry.getValue().replace("{", "").replace("}", "").trim())
						? TestVariables.map.get(entry.getValue().replace("{", "").replace("}", "").trim()).toString()
						: entry.getValue().toString()));
	}
}
