package com.wecanendcraving.encryption;

import com.google.common.io.BaseEncoding;
import static com.google.common.base.Preconditions.checkArgument;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

public class MainApp {

    static AESCipher cipher= new AESCipher();
    
    public static void main(String[] args) {

        checkArgument(args.length > 0, "Usage: java -jar <pathToJar.jar> command");

        String command = args[0];
        switch(command) {
            case "generateKey":
                showKey(cipher.generateAESKey());
                break;
            case "splitKey":
            	System.out.println("\n\nSplit Key 1 \n================");
        		byte[] generatedKey1= cipher.generateAESKey();
        		showKey(generatedKey1);
        		System.out.println("\n\nSplit Key 2 \n================");
        		byte[] generatedKey2= cipher.generateAESKey();
        		showKey(generatedKey2);
        		System.out.println("\n\nSplit Key 3 \n================");
        		byte[] decodedKey = BaseEncoding.base16().decode(args[1]);
        		// rebuild key using SecretKeySpec
        		SecretKey originalKey = new SecretKeySpec(decodedKey, 0, decodedKey.length, "AES"); 
				byte[] generatedKey3= new byte[originalKey.getEncoded().length];
        		int x=0;
        		while (x < (originalKey.getEncoded().length)){
        			generatedKey3[x] = (byte) (generatedKey1[x] ^ generatedKey2[x] ^ originalKey.getEncoded()[x]);
        			++x;
        		}
        		showKey(generatedKey3);
            	break;
            case "mergeKeys":
			int y=0;
			byte[] decodedKey1 = BaseEncoding.base16().decode(args[1]);
			// rebuild key using SecretKeySpec
			SecretKey originalDecodedKey1 = new SecretKeySpec(decodedKey1, 0, decodedKey1.length, "AES"); 
			byte[] decodedKey2 = BaseEncoding.base16().decode(args[2]);
			// rebuild key using SecretKeySpec
			SecretKey originalDecodedKey2 = new SecretKeySpec(decodedKey2, 0, decodedKey2.length, "AES"); 
			byte[] decodedKey3 = BaseEncoding.base16().decode(args[3]);
			// rebuild key using SecretKeySpec
			SecretKey originalDecodedKey3 = new SecretKeySpec(decodedKey3, 0, decodedKey3.length, "AES");
			byte[] finalAESKey= new byte[originalDecodedKey1.getEncoded().length];
			while (y < originalDecodedKey1.getEncoded().length){
				finalAESKey[y] = (byte) (originalDecodedKey1.getEncoded()[y] ^ originalDecodedKey2.getEncoded()[y] ^ originalDecodedKey3.getEncoded()[y]);
				++y;
			}
			showKey(finalAESKey);
        }
    }
    
    private static void showKey(byte[] key) {
        System.out.println("\n\nGenerated AES Key\n===========================================");
        System.out.println("Key (Base64 Encoded): " + BaseEncoding.base64().encode(key));
        System.out.println("Key (Hex Encoded): " + BaseEncoding.base16().encode(key));
        System.out.println("Key (Base32 Encoded): " + BaseEncoding.base32().encode(key));
        System.out.println("KCV: " + cipher.kcv(key));
    }
    
}
