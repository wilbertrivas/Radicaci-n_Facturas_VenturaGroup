
package GUI2;

import Modelos.AutenticacionDominio;

public class NewClass {
    public static void main(String[] args) {
       AutenticacionDominio autenticacionDominio= new AutenticacionDominio();
        if(autenticacionDominio.login("recepciongp", "Alex.2020")){
           System.out.println("Si autenticó");
        }else{
           System.out.println("No autenticó");
        }
    }
}
