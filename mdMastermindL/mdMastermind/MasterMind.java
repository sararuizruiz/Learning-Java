package org.uma.mbd.mdMastermindL.mdMastermind;

import java.util.Random;

public class MasterMind {
    public static int TAMANO_POR_DEFECTO = 4;
    private static Random alea = new Random();

    protected String combinacionSecreta;

    public MasterMind(int tamano) {
        if (tamano <= 0 || tamano >10)
            throw new MasterMindException("El número de cifras debe estar entre 1 y 10.");
        generaCombinacionSecreta(tamano);
    }

    public MasterMind() {
        this(TAMANO_POR_DEFECTO);
    }

    public MasterMind(String comb) {
        combinacionSecreta = comb;
    }

    private void generaCombinacionSecreta (int tamano) {
        combinacionSecreta = new String();
        while (combinacionSecreta.length()<tamano) {
            int num = alea.nextInt(10);
            if (!combinacionSecreta.contains(Integer.toString(num)))
                combinacionSecreta += Integer.toString(num);
        }
    }

    public int getLongitud() {
        return combinacionSecreta.length();
    }

    public String getSecreto() {
        return combinacionSecreta;
    }

    private boolean validaCombinacion(String cifras) {
        return (cifras.length() == getLongitud()
            && cifras.matches("\\d*") 
            && cifras.chars().distinct().count() == cifras.length());
    }

    public Movimiento intento(String cifras) {
        if (validaCombinacion(cifras)) {
            int col = 0;
            int descol = 0;
            for (int i = 0; i < cifras.length(); i++) {
                if (cifras.charAt(i) == combinacionSecreta.charAt(i)) {
                    col += 1;
                } else if (combinacionSecreta.indexOf(cifras.charAt(i)) >= 0) {
                    descol +=1;
                }
            }
            return new Movimiento(cifras, col, descol);
        } else {
            throw new MasterMindException("La cadena de cifras no es válida.");
        }
    }




    
    
}
