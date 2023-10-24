package org.uma.mbd.mdTestL.tests;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class TestAsignatura {
    private String nombreAsignatura;
    private double valorAciertos;
    private double valorErrores;
    private List<Test> examenes;

    private static final double APROBADO = 5;

    public TestAsignatura(String nA, double vA, double vE, List<String> datos) {
        if (vA <= 0 || vE > 0)
            throw new RuntimeException("El valor de los aciertos debe ser positivo y el de los errores negativo o cero");
        nombreAsignatura = nA;
        valorAciertos = vA;
        valorErrores = vE;
        examenes = new ArrayList<>();
        extraeDatos(datos);
    }

    public TestAsignatura(String nA, List<String> datos) {
        this(nA, 1, 0, datos);
    }

    private void extraeDatos(List<String> datos) {
        for (String dato: datos) {
            try (Scanner sc = new Scanner(dato)) {
                sc.useDelimiter("[:+]");
                String al = sc.next();
                int ac = sc.nextInt();
                int err = sc.nextInt();
                examenes.add(new Test(al, ac, err));
            } catch(InputMismatchException e) {
                System.err.println("El dato siguiente tiene un número erróneo: "+dato);
            } catch(NoSuchElementException e) {
                System.err.println("El dato siguiente está incompleto: "+dato);
            }
        }
    }

    public String getNombre() {
        return nombreAsignatura;
    }

    public double notaMedia() { // tb se puede hacer con stream
        double sum = 0;
        for (Test test : examenes)
            sum += test.calificacion(valorAciertos, valorErrores);
        return sum / examenes.size();
        
    }

    public int aprobados() {
        return (int)examenes.stream()
                .filter(test -> test.calificacion(valorAciertos, valorErrores) >= APROBADO)
                .count();
    }
    
}
