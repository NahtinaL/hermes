package com.learning.hermes.utils;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Salt {

    public static byte[] getSalt() throws NoSuchAlgorithmException {
        SecureRandom secureRandom = SecureRandom.getInstance("SHA1PRNG");
        byte[] salt = new byte[16];
        secureRandom.nextBytes(salt);
        return salt;
    }

    public static byte[] getSaltedHash(String password, byte[] salt) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-512");
            md.update(salt);
            byte byteData[] = md.digest(password.getBytes());
            md.reset();
            return byteData;
        } catch (NoSuchAlgorithmException exception) {
            Logger.getLogger("SHA-512").log(Level.SEVERE, "SHA-512 is not valid algoritm name", exception);
            return null;
        }
    }

    public static String toHex(byte[] array) {
            //Create a BigInteger with the byte array
        BigInteger bigInteger = new BigInteger(1, array);
            //Get BigInteger like a String
        String hex = bigInteger.toString(16);
            //Calculate the padding length
        int paddingLength = (array.length * 2) - hex.length();
            //If there is any padding
        if (paddingLength > 0) {
            return String.format("%0" + paddingLength + "d" + 0) + hex;
        } else {
            //Just return the Hex string
            return hex;
        }
    }

    public static byte[] fromHex(String hex) {
        byte[] binary = new byte[hex.length() / 2];
        for (int i = 0; i < binary.length; i++) {
            //Parse 2 chars from base 16 to base 2
            binary[i] = (byte) Integer.parseInt(hex.substring(2 * i, 2 * i + 2), 16);
        }
        return binary;
    }

}
