package gt.gob.segeplan.sisag.core.web.utils;

import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import java.io.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
//import sun.misc.BASE64Decoder;
 
public class encriptarAES256 implements Serializable{

    ByteArrayOutputStream baos = new ByteArrayOutputStream();
    private static final char[] CONSTS_HEX = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    public static SecretKeySpec getKeySpec() throws IOException, NoSuchAlgorithmException {
        byte[] bytes = new byte[16];
        File f = new File("sample_aes_key");
        SecretKey key = null;
        SecretKeySpec spec = null;
        if (f.exists()) {
            new FileInputStream(f).read(bytes);
        } else {
            KeyGenerator kgen = KeyGenerator.getInstance("AES");
            kgen.init(256);
            key = kgen.generateKey();
            bytes = key.getEncoded();
            new FileOutputStream(f).write(bytes);
        }
        spec = new SecretKeySpec(bytes, "AES");
        return spec;
    }

    public String encriptaEnMD5(String stringAEncriptar) {

        try {
            MessageDigest msgd = MessageDigest.getInstance("MD5");
            byte[] bytes = msgd.digest(stringAEncriptar.getBytes());
            StringBuilder strbCadenaMD5 = new StringBuilder(2 * bytes.length);
            for (int i = 0; i < bytes.length; i++) {
                int bajo = (int) (bytes[i] & 0x0f);
                int alto = (int) ((bytes[i] & 0xf0) >> 4);
                strbCadenaMD5.append(CONSTS_HEX[alto]);
                strbCadenaMD5.append(CONSTS_HEX[bajo]);
            }
            return strbCadenaMD5.toString();

        } catch (NoSuchAlgorithmException e) {
            return null;
        }
    }
    
    
/* 
    public StringBuffer encrypt(String text) throws Exception {

        StringBuffer encrypt = new StringBuffer();

        SecretKeySpec spec = getKeySpec();
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE, spec);

        try (OutputStream base64OutputStream = MimeUtility.encode(baos, "base64")){
            base64OutputStream.write(cipher.doFinal(text.getBytes()));
        } catch (Exception e) {
        }

        encrypt.append(baos.toString());
        System.out.println("encoded String " + encrypt.toString());

        return encrypt;
    }
    /* public StringBuffer decrypt(String text) throws Exception {
     StringBuffer descrypt = new StringBuffer();
      
     SecretKeySpec spec = getKeySpec();
     Cipher cipher = Cipher.getInstance("AES");
     cipher.init(Cipher.DECRYPT_MODE, spec);
       

     BASE64Decoder dec = new BASE64Decoder();

     descrypt.append(new String(cipher.doFinal(dec.decodeBuffer(text))));
     System.out.println("decoded String " + descrypt.toString());
      
     return descrypt;
     }
     */
}
