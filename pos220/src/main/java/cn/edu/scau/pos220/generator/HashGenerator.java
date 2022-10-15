package cn.edu.scau.pos220.generator;

import java.util.*;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class HashGenerator {
    HashGenerator() {
    }

    private String str;

    HashGenerator(String str) {
        this.str = str;
    }

    public String getMD5() {
        return generatorMD5().toUpperCase();
    }

    private String generatorMD5() {
        byte[] msg = str.getBytes();

        byte[] hash = null;
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            hash = md.digest(msg);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        StringBuilder strBuilder = new StringBuilder();
        for (byte b : hash) {
            strBuilder.append(String.format("%02x", b));
        }
        String strHash = strBuilder.toString();
        return strHash;
    }
}
