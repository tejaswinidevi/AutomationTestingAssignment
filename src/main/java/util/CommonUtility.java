package util;

import java.util.Random;

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
}
