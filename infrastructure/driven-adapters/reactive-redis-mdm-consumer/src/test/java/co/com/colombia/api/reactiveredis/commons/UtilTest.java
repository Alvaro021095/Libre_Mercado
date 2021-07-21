package co.com.colombia.api.reactiveredis.commons;

import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class UtilTest {


    @Test
    public void testFormattedKey(){

        String clientType = "CC";
        String clientId = "1234567";


        String result = Util.formattedKey(clientType, clientId);
        assertNotNull(result);

    }

    @Test
    public void testFormattedKeyUserFlag(){

        String clientType = "CC";
        String clientId = "1234567";


        String result = Util.formattedKeyUserFlag(clientType, clientId);
        assertNotNull(result);

    }

}
