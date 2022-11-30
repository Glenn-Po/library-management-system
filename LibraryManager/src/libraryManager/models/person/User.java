
package libraryManager.models.person;

/**
 *
 * @author Admin
 */

import libraryManager.models.Person;

public class User extends Person{
   private final String username;
   
   public User(){
       super();
       this.name = null;
       this.username = null;
   }
   //getters
   
   public String getUsername(){
       return username;
   }
   
   public boolean borrowBook(){
       return true;
   }
   
}
