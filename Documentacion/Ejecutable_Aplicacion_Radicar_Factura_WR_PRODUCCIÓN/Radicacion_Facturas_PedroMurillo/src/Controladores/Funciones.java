
package Controladores;
   
public class Funciones {
    public  byte generarDigitoVerificacion(long nit){
        int[] nums = {3,7,13,17,19,23,29,37,41,43,47,53,59,67,71};
        int sum =0;
        String str = String.valueOf(nit);
        for(int i = str.length()-1, j=0; i >=0; i--, j++){
            sum += Character.digit(str.charAt(i), 10) * nums[j];
        }
        byte dv= (byte)((sum % 11) > 1 ? (11- (sum % 11)): (sum % 11));
        return dv;
    }   
   
}
