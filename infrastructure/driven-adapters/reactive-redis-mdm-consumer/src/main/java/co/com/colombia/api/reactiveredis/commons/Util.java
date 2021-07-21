package co.com.colombia.api.reactiveredis.commons;


public class Util {

    public static final String SEPARATOR = ":";

    private Util() {
        throw new IllegalStateException("Utility class");
    }

    public static String formattedKey(String typeDocument, String documentNumber){
        return  typeDocument+ SEPARATOR+ documentNumber;
    }



}
