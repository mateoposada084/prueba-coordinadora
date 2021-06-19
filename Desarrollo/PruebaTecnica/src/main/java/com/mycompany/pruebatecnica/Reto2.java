package com.mycompany.pruebatecnica;

import java.util.Scanner;

public class Reto2 {
    static Scanner scanner = new Scanner(System.in);
    static float[][] vacas;
    
    private static void iniciarMatriz() {
        System.out.println("Ingrese la cantidad de vacas: ");
        int cantidad = scanner.nextInt();
        
        while (cantidad < 3 || cantidad > 50) {
            System.out.println("La cantidad que ingresó es menor que 3 o mayor que 50");
            cantidad = scanner.nextInt();
        }
        
        vacas = new float[7][cantidad];
    }
    
    public static void registrarDatos() {
        System.out.println("\nRegistrar datos por vaca\n");
        System.out.println(vacas.length);
        for (int i = 0; i < vacas.length; i++) {
            for (int j = 0; j < vacas[i].length; j++) {
                System.out.println("Producción de leche de la vaca " + (j + 1) + " del dia " + (i +1));
                float litros = scanner.nextFloat();
                
                while (litros < 0 || litros > 11.9) {
                    System.out.println("La cantidad de litros de leche ingresados es menor a 0.0 o mayor a 11.9");
                    litros = scanner.nextFloat();
                }
                vacas[i][j] = litros;
            }
        }
    }
    
    public static float[] ordenarVector(float[] vector) {
        for (int i = 0; i < vector.length; i++) {
            for (int j = 0; j < vector.length; j++) {
                if (vector[i] < vector[j]) {
                    float temp = vector[i];
                    vector[i] = vector[j];
                    vector[j] = temp;
                }
            }
        }
        return vector;
    }
    
    public static int sumar(float[] vector) {
        int resultado = 0;
        for (int i = 0; i < vector.length; i++) {
            resultado += vector[i];
        }
        return resultado;
    }
    
    public static void sumaTotal() {
        System.out.println("x-x-x-x-x-x-x-x-x\n"
                + "Suma por días:");
        System.out.println(vacas.length);
        for (int i = 0; i < vacas.length; i++) {
            System.out.println("Día " + (i + 1) + ": " + sumar(vacas[i]) + " litros");
        }
        System.out.println("x-x-x-x-x-x-x-x-x\n");
    }
    
    public static void mayorMenorProduccion() {
        float[] resultados = new float[vacas.length];
        int mayor = -1;
        float produccionMayor = 0;
        int menor = -1;
        float produccionMenor = 100;
        
        System.out.println("x-x-x-x-x-x-x-x-x\n"
                + "Dia con mayor y menor produccion:");
        
        for (int i = 0; i < vacas.length; i++) {
            resultados[i] = sumar(vacas[i]);
        }
        
        for (int i = 0; i < resultados.length; i++) {
            if (resultados[i] > produccionMayor) {
                produccionMayor = resultados[i];
                mayor = i + 1;
            }
            if (resultados[i] < produccionMenor){
                produccionMenor = resultados[i];
                menor = i + 1;
            }
        }
        
        System.out.println("Mayor produccion: Dia " + mayor);
        System.out.println("Menor produccion: Dia " + menor);
        System.out.println("x-x-x-x-x-x-x-x-x\n");
    }
    
    public static void mayorProduccionDia() {
        System.out.println("x-x-x-x-x-x-x-x-x\n"
                + "Mayor produccion por dia:");
        for (int i = 0; i < vacas.length; i++) {
            float mayorProduccion = 0;
            String mensaje = "";
            for (int j = 0; j < vacas[i].length; j++) {
                if (vacas[i][j] > mayorProduccion) {
                    mayorProduccion = vacas[i][j];
                }
            }
            for (int j = 0; j < vacas[i].length; j++) {
                if (vacas[i][j] == mayorProduccion) {
                    mensaje += " Vaca " + (j + 1);
                }
            }
            System.out.println("Dia " + (i + 1) + ": " + mensaje);
        }
        System.out.println("x-x-x-x-x-x-x-x-x\n");
    }
    
    public static void  menu() {
        int opcion = -1;
        do {
            String menuString = """
                Elija una de las siguientes opciones:
                1. Suma total por dia
                2. Dia con mayor y menor produccion
                3. Mas produccion por dia
                4. Salir
                --------------------------------------""";
            System.out.println(menuString);
            opcion = scanner.nextInt();
            switch (opcion) {
                case 1: 
                    sumaTotal();
                    break;
                case 2: 
                    mayorMenorProduccion();
                    break;
                case 3:
                    mayorProduccionDia();
                    break;
                case 4: 
                    return;
                
                default: System.out.println("Elige una opcion valida");
                
            }
            
        } while (opcion != 4);
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        iniciarMatriz();
        registrarDatos();
        menu();
    }
    
}
