package hash;
import java.security.MessageDigest;
public class SHA {
   public static void main(String[] args) throws Exception {

      MessageDigest md = MessageDigest.getInstance("SHA");
      md.update("texto a cifrar".getBytes());
      byte[] digest = md.digest();

      // Se escribe byte a byte en hexadecimal
      for (byte b : digest) {
         System.out.print(Integer.toHexString(0xFF & b));
      }
   }
}