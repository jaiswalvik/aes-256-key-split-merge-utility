package com.wecanendcraving.encryption;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.io.BaseEncoding;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

public class AESCipherTest {

    private static final Logger LOG = LoggerFactory.getLogger(AESCipherTest.class);

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void generateAESKey() {
    	AESCipher cipher= new AESCipher();
    	byte[] key =cipher.generateAESKey();
    	LOG.debug("Key (Base64 Encoded): {}", BaseEncoding.base64().encode(key));
    	LOG.debug("Key (Base32 Encoded): {}", BaseEncoding.base32().encode(key));
    	LOG.debug("Key (Base16 Encoded): {}", BaseEncoding.base16().encode(key));
        assertThat(key, is(notNullValue()));
        assertThat(Integer.toString((BaseEncoding.base16().encode(key).length())), is("64"));
    }
    
    @Test
    public void generateAESKeyWithInputKeySize() {
    	String keySize="256";
    	AESCipher cipher= new AESCipher();
    	byte[] key =cipher.generateAESKey(keySize);
    	LOG.debug("Key (Base64 Encoded): {}", BaseEncoding.base64().encode(key));
    	LOG.debug("Key (Base32 Encoded): {}", BaseEncoding.base32().encode(key));
    	LOG.debug("Key (Base16 Encoded): {}", BaseEncoding.base16().encode(key));
        assertThat(key, is(notNullValue()));
        assertThat(Integer.toString((BaseEncoding.base16().encode(key).length())), is("64"));
    }
    
    @Test
    public void kcv(){
    	AESCipher cipher= new AESCipher();
    	byte[] key =cipher.generateAESKey();
    	String kcv=cipher.kcv(key);
    	LOG.debug("KCV: {}", kcv);
   	    assertThat(key,is(notNullValue()));
   	    assertThat(Integer.toString(kcv.length()),is("6")); 
    }
}
