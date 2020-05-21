package aesexample;
import java.security.Key;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;
import java.util.Base64;
import javax.crypto.*;


//Cryptography

public class AESExample {

    private static final String ALGO="AES";
    private byte[] keyValue;
    //constructor
    public AESExample(String key) {
        keyValue=key.getBytes();
    }
    //Encryption
    public String encrypt(String Data) throws Exception{
        Key key= generateKey();
        Cipher c = Cipher.getInstance(ALGO);
        c.init(Cipher.ENCRYPT_MODE,key);
        byte[] encVal=c.doFinal(Data.getBytes());
        String encryptedValue=new BASE64Encoder().encode(encVal);
        return encryptedValue;
    }
    //Decryption
    public String decrypt(String encryptedData) throws Exception{
        Key key= generateKey();
        Cipher c = Cipher.getInstance(ALGO);
        c.init(Cipher.DECRYPT_MODE, key);
        byte[] decodedValue = new BASE64Decoder().decodeBuffer(encryptedData);
        byte[] decValue=c.doFinal(decodedValue);
        String decryptedValue=new String(decValue);
        return decryptedValue;
    }
    //Generating key
    private Key generateKey() throws Exception{
        Key key=new SecretKeySpec(keyValue, ALGO);
        return key;
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        try{
        AESExample aes=new AESExample("1v39ept1vuhaqqsq");
        String encdata= aes.encrypt("Umer");
        System.out.println("Encrypted data is "+encdata);
        String decdata = aes.decrypt(encdata);
        System.out.println("Decrypted data is "+decdata);
        
        }catch(Exception ex){
            Logger.getLogger(AESExample.class.getName()).log(Level.SEVERE, null,ex);
        }
       
        
        
    }
    
}
