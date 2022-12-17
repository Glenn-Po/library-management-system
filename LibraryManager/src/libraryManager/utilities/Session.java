
package libraryManager.utilities;

import libraryManager.models.Account;

public class Session {
    private static Session sessionInstance;
    private final Account account;
    
    private Session(Account account){
        this.account = account;
    }
    
    public Account getAccount(){
        return sessionInstance.account;
    }
    public static void startSession(Account account){
        if(sessionInstance == null){
            sessionInstance = new Session(account);
        }
    }
    
    public static Session getSession() {
        return sessionInstance;
    }
    
    public static void killSession(){
        sessionInstance = null;
    }
}
