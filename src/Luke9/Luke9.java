package Luke9;

import java.io.*;
import java.math.BigInteger;
import java.security.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Luke9 {

    public static void main(String args[]) throws FileNotFoundException, NoSuchAlgorithmException {
        String originalHash = md5("julekalender");
        //Key = character & hash = value
        ArrayList<HashMap<String, String>> listOfHashmaps= new ArrayList<>();
        File file = new File("./src/Luke9/inputLuke9.txt");
        Scanner sc = new Scanner(file);

        while (sc.hasNextLine()) {
            String[] line = sc.nextLine().split(";");
            HashMap<String, String> hashmap = new HashMap<>();
            hashmap.put("char", line[0]);
            hashmap.put("hash", line[1]);
            listOfHashmaps.add(hashmap);
        }

        System.out.println(decrypt(listOfHashmaps, originalHash, ""));

    }

    private static HashMap<String, String> findCharHashPair(String hash, ArrayList<HashMap<String, String>> arraylist) throws NoSuchAlgorithmException {
        for (int i = 0; i < arraylist.size(); i++) {
            HashMap<String, String> charHashPair = arraylist.get(i);
            if (md5(hash+charHashPair.get("char")).equals(charHashPair.get("hash"))) {
                return charHashPair;
            }
        }
        return null;
    }

    public static String decrypt(ArrayList<HashMap<String, String>> charHashPairList, String previousHash, String message) throws NoSuchAlgorithmException {
        HashMap<String, String> newCharHashPair = findCharHashPair(previousHash, charHashPairList);
        if (newCharHashPair == null) {
            return message;
        } else {
            return decrypt(charHashPairList, newCharHashPair.get("hash"), message+newCharHashPair.get("char"));
        }
    }


    public static String md5(String last_hash) throws NoSuchAlgorithmException {
        MessageDigest m = MessageDigest.getInstance("MD5");
        m.reset();
        m.update(last_hash.getBytes());
        byte[] digest = m.digest();
        BigInteger bigInt = new BigInteger(1,digest);
        String hashtext = bigInt.toString(16);
        //Remove padding to get the full 32 chars.
        while(hashtext.length() < 32 ){
            hashtext = "0"+hashtext;
        }
        return hashtext;
    }
}
