import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.*;
public class Luke9 {

    public static void main (String args[]) throws UnsupportedEncodingException, NoSuchAlgorithmException, NoSuchProviderException {
        String en = md5("julekalender", "");
        String to = md5(en, "u");

       
    }

    public static String md5(String forrige_hash, String bokstav) throws NoSuchAlgorithmException {
        String newHash = forrige_hash + bokstav;
        MessageDigest m = MessageDigest.getInstance("MD5");
        m.reset();
        m.update(newHash.getBytes());
        byte[] digest = m.digest();
        BigInteger bigInt = new BigInteger(1,digest);
        String hashtext = bigInt.toString(16);
// Now we need to zero pad it if you actually want the full 32 chars.
        while(hashtext.length() < 32 ){
            hashtext = "0"+hashtext;
        }

        return hashtext;
    }
}
