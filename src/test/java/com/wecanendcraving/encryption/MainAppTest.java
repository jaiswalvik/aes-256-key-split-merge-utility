package com.wecanendcraving.encryption;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MainAppTest {
	private static final Logger LOG = LoggerFactory.getLogger(MainAppTest.class);

    @Before
    public void showGeneratedKey() {
    	LOG.debug("\n\nAES-256 to be split \n=====================================================");
    	LOG.debug("Generated Key: 483C9B750AE820F4FE4196125F65008F2F67874AD3F3043B4F8537CF675A449A");
    	LOG.debug("KCV: D51950");
    	LOG.debug("\n\n=====================================================");
    }

    @Test
    public void splitKey() {
    	MainApp.main(createArguments("splitKey", "483C9B750AE820F4FE4196125F65008F2F67874AD3F3043B4F8537CF675A449A"));
    }

    @Test
    public void mergeKeys() {
    	LOG.debug("\n\n Key retreived after merge: \n=====================================================");
    	MainApp.main(createArguments("mergeKeys", "2820C42135974F13291A369070B9D660E78C26AFB33083DE20E94F45811389AE","DA75BFA51C65BCAB57EDB1FE264C43137198B39C69B32E4D0E3EA0453B289D81","BA69E0F1231AD34C80B6117C099095FCB97312790970A9A86152D8CFDD6150B5"));
    }

    private String[] createArguments(String... args) {
        return args;
    }

}
