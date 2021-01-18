package com.ensah.utils;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.util.Arrays;
import java.util.Base64;
import java.util.Random;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

public class PasswordUtil {

	private static final Random RANDOM = new SecureRandom();
	private static final String ALPHABET = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
	private static final int ITERATIONS = 10000;
	private static final int KEY_LENGTH = 256;
	private static final int LENGTH = 30;

	public static String generateCleUtilisateur() {
		StringBuilder cle = new StringBuilder(LENGTH);
		for (int i = 0; i < LENGTH; i++) {
			cle.append(ALPHABET.charAt(RANDOM.nextInt(ALPHABET.length())));
		}
		return new String(cle);
	}

	public static byte[] hash(char[] motDePasse, byte[] cleUtilisateur) {
		PBEKeySpec spec = new PBEKeySpec(motDePasse, cleUtilisateur, ITERATIONS, KEY_LENGTH);
		Arrays.fill(motDePasse, Character.MIN_VALUE);
		try {
			SecretKeyFactory skf = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
			return skf.generateSecret(spec).getEncoded();
		} catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
			throw new AssertionError("Error while hashing a password: " + e.getMessage(), e);
		} finally {
			spec.clearPassword();
		}
	}

	public static String generateSecureMotDePasse(String motDePasse, String cleUtilisateur) {
		String returnValue = null;
		byte[] securePassword = hash(motDePasse.toCharArray(), cleUtilisateur.getBytes());
		returnValue = Base64.getEncoder().encodeToString(securePassword);
		return returnValue;
	}

	public static boolean verifierMotDePasse(String providedPassword, String securedPassword, String cleUtilisateur) {
		boolean returnValue = false;
		String newSecurePassword = generateSecureMotDePasse(providedPassword, cleUtilisateur);
		returnValue = newSecurePassword.equalsIgnoreCase(securedPassword);
		return returnValue;
	}
}