
package Modelos;
 
import java.util.Hashtable;
import javax.naming.Context;
import javax.naming.NamingException;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;
  
public class AutenticacionDominio {
    
    public boolean login(String username, String password) {
        String LDAP_URL = "ldap://goib.com:389/DC=goib,DC=com";
        Hashtable env = new Hashtable();
        env.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
        env.put(Context.PROVIDER_URL, LDAP_URL);
        env.put(Context.SECURITY_AUTHENTICATION, "simple");
        env.put(Context.SECURITY_PRINCIPAL, username.toUpperCase()+ "@goib.com");
        env.put(Context.SECURITY_CREDENTIALS, password);
        try {
            DirContext ctx = new InitialDirContext(env);
            return true;
        } catch (NamingException ex) {
            return false;
        }       
    }
}
