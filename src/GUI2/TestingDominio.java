
package GUI2;

import Modelos.AutenticacionDominio;


public class TestingDominio {
    public static void main(String[] args) {
        AutenticacionDominio c = new AutenticacionDominio();
        boolean result=c.login("wrivas", "Wr1v4s1992$");
        if(result){
            System.out.println("Yes");
        }else{
            System.out.println("Not");
        }
    }
}
