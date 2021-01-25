import finalProject.security.PasswordEncrypter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordGenerator {
   public static void main(String[] args) {
      //BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();/  String rawPassword = "trainer";
      String encodedPassword = PasswordEncrypter.getEncoded("trainer");
       System.out.println(encodedPassword);
    }
}
