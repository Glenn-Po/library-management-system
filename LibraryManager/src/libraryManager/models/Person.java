
package libraryManager.models;
/**
 *
 * @author Admin
 */
public abstract class Person {
    protected String name;
    
    protected enum role{ADMIN, LIBRARIAN, USER};
    
    protected Person(){
        name = null;
    }
    
    public String getName(){
        return name;
    }
}
