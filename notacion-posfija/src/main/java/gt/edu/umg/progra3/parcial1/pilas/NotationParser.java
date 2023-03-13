package gt.edu.umg.progra3.parcial1.pilas;

import java.util.Arrays;
import java.util.Collections;

public class NotationParser {

    private Pila pila1;
    private Pila pila2 = new Implementacion();

    public NotationParser(Pila pila) {
        this.pila1 = pila;
    }

    public String posFixToInfix(String expression){

        pila1 = StringToPila(expression);
        return PostFijo(pila1);

    }
    private Pila StringToPila(String cadena){
        Pila r = new Implementacion();
        String[] strArray = cadena.split(" ");
        Collections.reverse(Arrays.asList(strArray));
        for(String x:strArray){
            r.push(x);
        }
        return r;
    }
    private String PostFijo(Pila pila){
        String Operador, Num;
        String Resul = "";
        while(!pila.isEmpty()){
            pila2.push(pila1.pop());
            String fin = pila2.peek();
            if(fin.equals("+")||fin.equals("*")||fin.equals("-")||fin.equals("/")){
                Operador = pila2.pop();
                Num = pila2.pop();
                pila2.push(Operador);
                pila2.push(Num);
            }
        }
        Resul = pilaToString(pila2);
        return Resul;
    }
    private String pilaToString(Pila pila){
        int tamaño = pila.size();
        String resul2 = "";
        resul2 = pila.pop()+resul2;
        for(int x = 0;x<tamaño-1;x++){
            resul2 = pila.pop()+" "+resul2;
        }
        return resul2;
    }




}
