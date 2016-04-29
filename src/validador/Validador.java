/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package validador;

import javax.swing.JTextField;

/**
 *
 * @author Entix_003
 */
public class Validador {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        // TODO code application logic here
    }
    
    public char dv(String a){
        char dv='n';
        int i=0;
        while (i<10){
            if(validarRut(a,String.valueOf(i)))
            {
                dv= String.valueOf(i).charAt(0);
                return dv;
            }
            else{
                    i++;
                    }
            System.out.println("Probamos "+ i);
        }
        if(validarRut(a,"k")){
        dv= 'k';
        System.out.println("Probamos k");
        }
        return dv;
    }
    
    public static boolean validarRut(String vrut, String vverificador)
    {
        boolean flag = false;
        String rut = vrut.trim();

        String posibleVerificador = vverificador.trim();
        int cantidad = rut.length();
        int factor = 2;
        int suma = 0;
        String verificador = "";

        for(int i = cantidad; i > 0; i--)
        {
            if(factor > 7)
            {
                factor = 2;
            }
            suma += (Integer.parseInt(rut.substring((i-1), i)))*factor;
            factor++;

        }
        verificador = String.valueOf(11 - suma%11);
        if(verificador.equals(posibleVerificador))
        {
            flag = true;
        }
        else
        {
            if((verificador.equals("10")) && (posibleVerificador.toLowerCase().equals("k")))
            {
                flag = true;
            }
            else
            {
                if((verificador.equals("11") && posibleVerificador.equals("0")))
                {
                    flag = true;
                }
                else
                {
                    flag = false;
                }
            }
        }
        return flag;        
    }  

}
