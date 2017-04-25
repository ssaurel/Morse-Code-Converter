package com.ssaurel.morseconverter;

import java.util.HashMap;

public class MorseCode {

	static String[] ALPHA = { "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r",
			"s", "t", "u", "v", "w", "x", "y", "z", "1", "2", "3", "4", "5", "6", "7", "8", "9", "0", "!", ",", "?",
			".", "'" };
	static String[] MORSE = { ".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..",
			"--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--..", ".----",
			"..---", "...--", "....-", ".....", "-....", "--...", "---..", "----.", "-----", "-.-.--", "--..--",
			"..--..", ".-.-.-", ".----.", };

	public static HashMap<String, String> ALPHA_TO_MORSE = new HashMap<>();
    public static HashMap<String, String> MORSE_TO_ALPHA = new HashMap<>();

    static {
        for (int i = 0; i < ALPHA.length  &&  i < MORSE.length; i++) {
            ALPHA_TO_MORSE.put(ALPHA[i], MORSE[i]);
            MORSE_TO_ALPHA.put(MORSE[i], ALPHA[i]);
        }
    }

    public static String morseToAlpha(String morseCode) {
        StringBuilder builder = new StringBuilder();
        String[] words = morseCode.trim().split("   ");

        for (String word : words) {
            for (String letter : word.split(" ")) {
                String alpha = MORSE_TO_ALPHA.get(letter);
                builder.append(alpha);
            }

            builder.append(" ");
        }

        return builder.toString().toUpperCase();
    }

    public static String alphaToMorse(String englishCode) {
        StringBuilder builder = new StringBuilder();
        String[] words = englishCode.trim().split(" ");

        for (String word : words) {
            for (int i = 0; i < word.length(); i++) {
                String morse = ALPHA_TO_MORSE.get(word.substring(i, i + 1).toLowerCase());
                builder.append(morse).append(" ");
            }

            builder.append("  ");
        }

        return builder.toString();
    }

}