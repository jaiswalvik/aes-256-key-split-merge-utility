package com.wecanendcraving.encryption;

import com.google.common.base.Throwables;
import com.google.common.io.BaseEncoding;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class AESCipher {

    public byte[] generateAESKey(String keySize) {
    	//key size 128, 192 or 256 bits
        try {
        	KeyGenerator keyGen = KeyGenerator.getInstance("AES");
        	keyGen.init(Integer.parseInt(keySize)); 
        	SecretKey secretKey = keyGen.generateKey();
        	return secretKey.getEncoded();
        } catch (NoSuchAlgorithmException e) {
            throw Throwables.propagate(e);
        }
    }
    
    public byte[] generateAESKey() {
    	//key size 128, 192 or 256 bits
        try {
        	KeyGenerator keyGen = KeyGenerator.getInstance("AES");
        	keyGen.init(256); 
        	SecretKey secretKey = keyGen.generateKey();
        	return secretKey.getEncoded();
        } catch (NoSuchAlgorithmException e) {
            throw Throwables.propagate(e);
        }
    }
    public String kcv(byte[] key) {
        try {
        	// getInstance() method is called with algorithm SHA-1 
            MessageDigest md = MessageDigest.getInstance("SHA-1"); 
            // digest() method is called 
            // to calculate message digest of the input string 
            // returned as array of byte 
            byte[] messageDigest = md.digest(key); 
            return BaseEncoding.base16().encode(messageDigest).substring(0,6).toUpperCase();
        } catch (NoSuchAlgorithmException e) {
            throw Throwables.propagate(e);
        }
    }
    
}
