/****
 * Hashing of passwords
 * 
 * Validation with regex
 */
package libraryManager.utilities;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class Utilities {
    
    public static String hash(String input){
        String hash = null;
        try{
            MessageDigest md =  MessageDigest.getInstance("SHA-512");
            byte[] firstHash = md.digest(input.getBytes(StandardCharsets.UTF_8));
            byte[] secondHash = md.digest(firstHash);
            StringBuilder sb = new StringBuilder();
            for(byte hex : secondHash){
                sb.append(Integer.toString((hex & 0xFF) + 0x100, 16));
            }            
            hash = sb.toString();
        }catch(NoSuchAlgorithmException e){
            e.printStackTrace();
        }
        return hash;
    }
    
    public boolean matchRegex(String regex, String input){
        // Compile the ReGex
        Pattern p = Pattern.compile(regex);

        if (input == null) {
            return false;
        }
  
        // Pattern class contains matcher() method
        // to find matching between given string and regular expression.
        Matcher m = p.matcher(input);
  
        // Return if the string matched the ReGex
        return m.matches();
        
        //or
        //return Pattern.compile(regexPattern).matcher(emailAddress).matches()
    }
    
    public boolean isValidPassword(String password){
        String regex = "^(?=.*[0-9])" // numerical digits
                       + "(?=.*[a-z])(?=.*[A-Z])" //upper and lowercase letters
                       + "(?=.*[@#$%^&+=])" //Special character
                       + "(?=\\S+$)"  //No white space characters
                       + ".{8,20}$"; //Length between 8 and 20
        return true;//matchRegex(regex, password);
        
    }
    
//    The following restrictions are imposed in the email address' local part by using this regex:
//
//It allows numeric values from 0 to 9.
//Both uppercase and lowercase letters from a to z are allowed.
//Allowed are underscore “_”, hyphen “-“, and dot “.”
//Dot isn't allowed at the start and end of the local part.
//Consecutive dots aren't allowed.
//For the local part, a maximum of 64 characters are allowed.
//
//Restrictions for the domain part in this regular expression include:
//
//It allows numeric values from 0 to 9.
//We allow both uppercase and lowercase letters from a to z.
//Hyphen “-” and dot “.” aren't allowed at the start and end of the domain part.
//No consecutive dots.
    public boolean isValidEmail(String emailAdress){
        String emailPattern = "^(?=.{1,64}@)"
                + "[A-Za-z0-9_-]+(\\\\.[A-Za-z0-9_-]+)"
                + "*@[^-][A-Za-z0-9-]+(\\\\.[A-Za-z0-9-]+)"
                + "*(\\\\.[A-Za-z]{2,})$\n";
        return matchRegex(emailPattern, emailAdress);
    }
    
    public boolean isValidPhone(String PhoneNumber){
        //Basic phon number validation:
        // should contain only number and some special characters
        String basicPhonePattern = "^(?=.*[0-9])" // numerical digits
                       + "(?=.*[+-])" //Special character
                       //+ "(?=.*[@#$%^&+=])" //Special character
                       + "(?=\\S+$)"  //No white space characters
                       + ".{9,20}$"; //Length between 9 and 20
        return matchRegex(basicPhonePattern, PhoneNumber);
    }
    
}
