package com.ibiz.api.cmnUtil;

import org.springframework.stereotype.Repository;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.GeneralSecurityException;
import java.security.Key;
import java.security.KeyFactory;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.RSAPublicKeySpec;
import org.apache.tomcat.util.codec.binary.Base64;

import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.DESedeKeySpec;

@Repository(value="securityUtill")
public class SecurityUtil {
    public String RSAEncrypt(String value, String xmlpublicKey) throws GeneralSecurityException{

        RSAPublicKey clspublickey = loadPublicKey(xmlpublicKey);

        String encryptedString = "";

        try {
            Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
            cipher.init(cipher.ENCRYPT_MODE, clspublickey);

            byte[] arrCipherData = cipher.doFinal(value.getBytes("UTF-8"));

            //encryptedString = Base64.encodeBase64String(arrCipherData);
            encryptedString = Base64.encodeBase64String(arrCipherData);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        encryptedString = encryptedString == null ? "" : encryptedString;

        return encryptedString;


    }

    public String TripleDESDescrypt(String value, String key) throws Exception
    {
        if(value == null || value.length() == 0)
            return "";

        String instance = (key.length() == 24) ? "DESede/ECB/PKCS5Padding" : "DES/ECB/PKCS5Padding";
        Cipher cipher = Cipher.getInstance(instance);
        cipher.init(cipher.DECRYPT_MODE, getTripleDesKey(key));

        Base64 decoder = new Base64();

        byte[] inputBytes1 = decoder.decode(value);
        byte[] outputBytes2 = cipher.doFinal(inputBytes1);

        String strResult = new String(outputBytes2, "UTF8");

        return strResult;

    }

    public String TripleDESEncrypt(String value, String key) throws Exception
    {
        if(value == null || value.length() == 0)
            return "";

        String instance = (key.length() == 24) ? "DESede/ECB/PKCS5Padding" : "DES/ECB/PKCS5Padding";
        Cipher cipher = Cipher.getInstance(instance);
        cipher.init(cipher.ENCRYPT_MODE, getTripleDesKey(key));

        byte[] inputBytes1 = value.getBytes("UTF8");
        byte[] outputBytes1 = cipher.doFinal(inputBytes1);
        Base64 encoder = new Base64();
        String outputStr1 = encoder.encodeAsString(outputBytes1);

        return outputStr1;
    }

    private Key getTripleDesKey(String Key) throws Exception {
        if(Key.length() == 24)
        {
            DESedeKeySpec desKeySpec = new DESedeKeySpec(Key.getBytes());
            SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DESede");
            Key key = keyFactory.generateSecret(desKeySpec);

            return key;
        }
        else
        {
            DESKeySpec desKeySpec = new DESKeySpec(Key.getBytes());
            SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
            java.security.Key key = keyFactory.generateSecret(desKeySpec);
            return key;
        }
    }

    private RSAPublicKey loadPublicKey(String xmlpublickey) throws GeneralSecurityException {

        String strMudulePublicKey = "";
        String strExponentPublicKey = "";

        strMudulePublicKey = xmlpublickey.replaceAll("<RSAKeyValue><Modulus>", "");
        strMudulePublicKey = strMudulePublicKey.substring(0,strMudulePublicKey.indexOf("</"));
        strExponentPublicKey = xmlpublickey.substring(xmlpublickey.indexOf("<Exponent>"),xmlpublickey.indexOf("</Exponent>")).replace("<Exponent>", "");

        //BigInteger modulus = new BigInteger(1, Base64.decodeBase64(strMudulePublicKey));
        BigInteger modulus = new BigInteger(1, Base64.decodeBase64(strMudulePublicKey));

        //BigInteger pubExp = new BigInteger(1, Base64.decodeBase64(strExponentPublicKey));
        BigInteger pubExp = new BigInteger(1, Base64.decodeBase64(strExponentPublicKey));

        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        RSAPublicKeySpec pubKeySpec = new RSAPublicKeySpec(modulus, pubExp);
        RSAPublicKey key = (RSAPublicKey) keyFactory.generatePublic(pubKeySpec);

        return key;

    }
}
