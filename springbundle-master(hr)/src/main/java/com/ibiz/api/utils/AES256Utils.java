package com.ibiz.api.utils;

import com.ibiz.api.exception.InvalidMessageStructureException;
import org.apache.tomcat.util.codec.binary.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.io.*;
import java.security.Key;

public class AES256Utils {

    private static String initVector;
    private static Key keySpec;

    private static void initKeySpec(String key) throws UnsupportedEncodingException {
        initVector = key.substring(0, 16);
        byte[] keyBytes = new byte[16];
        byte[] keyBytesTemp = key.getBytes("UTF-8"); // UnsupportedEncodingException
        int keyBytesLen = keyBytesTemp.length < keyBytes.length ? keyBytesTemp.length : keyBytes.length;
        System.arraycopy(keyBytesTemp, 0, keyBytes, 0, keyBytesLen);
        keySpec = new SecretKeySpec(keyBytes, "AES");
    }

    public static String encrypt(Object plainText, String key) throws Exception {
        initKeySpec(key);
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding"); // NoSuchAlgorithmException, NoSuchPaddingException
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(baos); // IOException

        oos.writeObject(plainText);
        cipher.init(Cipher.ENCRYPT_MODE, keySpec, new IvParameterSpec(initVector.getBytes())); //InvalidKeyException

        byte[] cipherBytes = cipher.doFinal(baos.toByteArray()); // IllegalBlockSizeException, BadPaddingException

        return new String(Base64.encodeBase64(cipherBytes));
    }

    public static Object decrypt(String cipherText, String key) throws InvalidMessageStructureException {
        try {
            initKeySpec(key);

            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding"); // NoSuchAlgorithmException, NoSuchPaddingException
            cipher.init(Cipher.DECRYPT_MODE, keySpec, new IvParameterSpec(initVector.getBytes())); // InvalidKeyException, InvalidAlgorithmParameterException
            byte[] cipherBytes = Base64.decodeBase64(cipherText.getBytes());

            ByteArrayInputStream bais = new ByteArrayInputStream(cipher.doFinal(cipherBytes)); // IllegalBlockSizeException, BadPaddingException
            ObjectInputStream ois = new ObjectInputStream(bais); // IOException

            return ois.readObject(); // ClassNotFoundException
        } catch(Exception e) {
            throw new InvalidMessageStructureException();
        }
    }

}
