package com.mycompany.pruebatecnica;

import java.util.Scanner;

public class Reto1 {
    static Scanner scanner = new Scanner(System.in);
    static int tamanoMaximoDatos = 15;
    
    static int[] vector1;
    static int[] vector2;
    
    private static int[] iniciarVector(String nombreVector) {
        System.out.println("Ingresar tamaño del vector " + nombreVector);
        int tamano = scanner.nextInt();
        while (tamano > tamanoMaximoDatos) {
            System.out.println("El tamaño ingresado es mayor a " + tamanoMaximoDatos);
            tamano = scanner.nextInt();
        }
        return new int[tamano];
    }
    
    public static void registrarDatos(int[] vector, String nombreVector) {
        for (int i = 0; i < vector.length; i++) {
            System.out.println("Ingresar el valor " + (i +1) + " de " + nombreVector);
            int valor = scanner.nextInt();
            while (valor < 1 || valor > 30) {
                System.out.println("El valor ingresado debe ser mayor que 1 y menor que 30");
                valor = scanner.nextInt();
            }
            vector[i] = valor;
        }
    }
    
    public static void verRangoValores() {
        int[][] vectores = {vector1, vector2};
        int opcion = -1;
        int rango = 0;
        int[] vectorSeleccionado;
        
        System.out.println("""
        Elija uno de los vectores:
        1. Vector 1
        2. Vector 2
        -----------------------------------""");
        opcion = scanner.nextInt();
        switch (opcion) {
            case 1:
                vectorSeleccionado = vectores[0];
                break;
            case 2:
                vectorSeleccionado = vectores[1];
                break;
            default: 
                System.out.println("Debes seleccionar una opcion valida");
                return;
        }
        
        System.out.println("Ingrese el rango que desea ver del vector:");
        rango = scanner.nextInt();
        while ((rango > vectorSeleccionado.length) || rango < 1) {
            if (rango > vectorSeleccionado.length) {
                System.out.println("El rango seleccionado supera el tamaño del vector. (" + vectorSeleccionado.length + ")");
            } else if (rango < 1 ) {
                System.out.println("El rango seleccionado debe ser mayor a 0");
            }
            rango = scanner.nextInt();
        }
        
        System.out.println("x-x-x-x-x-x-x-x-x-x-x-x\n"
                + "Valores del rango del 1 al " + rango);
        for (int i = 0; i < rango; i++) {
            System.out.println("Posicion " + (i + 1 ) + ": " + vectorSeleccionado[i]);
        }
        System.out.println("x-x-x-x-x-x-x-x-x-x-x-x\n");
    }
    
    public static int[] ordenarVector(int[] vector) {
        for (int i = 0; i < vector.length; i++) {
            for (int j = 0; j < vector.length; j++) {
                if (vector[i] < vector[j]) {
                    int temp = vector[i];
                    vector[i] = vector[j];
                    vector[j] = temp;
                }
            }
        }
        return vector;
    }
    
    public static String crearMensaje(int[] vector) {
        String mensaje = "[";
        for (int i = 0; i < vector.length; i++) {
            mensaje = mensaje + vector[i];
            if (vector.length - 1 > i) {
                mensaje = mensaje + ",";
            }
        }
        return mensaje + "]";
    }
    
    public static void mostrarVector() {
        System.out.println("\nx-x-x-x-x-x-x-x-x-x-x-x");
        System.out.println("Vector 1: " + crearMensaje(ordenarVector(vector1)));
        System.out.println("Vector 2: " + crearMensaje(ordenarVector(vector2)));
        System.out.println("x-x-x-x-x-x-x-x-x-x-x-x-x\n");
    }
    
    public static int sumar(int[] vector) {
        int resultado = 0;
        for (int i = 0; i < vector.length; i++) {
            resultado += vector[i];
        }
        return resultado;
    }
    
    public static void sumarVectores() {
        System.out.println("\nx-x-x-x-x-x-x-x-x-x-x-x");
        System.out.println("Suma vector 1: " + sumar(vector1));
        System.out.println("Suma vector 2: " + sumar(vector2));
        System.out.println("x-x-x-x-x-x-x-x-x-x-x-x-x\n");
    }
    
    public static void  menu() {
        int opcion = -1;
        do {
            String menuString = """
                Elija una de las siguientes opciones:
                1. Ver rango de valores del vector
                2. Mostrar todo el vector
                3. Ver la suma de los vectores
                4. Salir
                --------------------------------------""";
            System.out.println(menuString);
            opcion = scanner.nextInt();
            switch (opcion) {
                case 1: 
                    verRangoValores();
                    break;
                case 2: 
                    mostrarVector();
                    break;
                case 3: 
                    sumarVectores();
                    break;
                case 4: 
                    return;
                
                default: System.out.println("Elige una opcion valida");
                
            }
            
        } while (opcion != 4);
    }
    
    public static void main(String[] args) {
        vector1 = iniciarVector("1");
        vector2 = iniciarVector("2");
        
        registrarDatos(vector1, "Vector 1");
        registrarDatos(vector2, "Vector 2");
        
        menu();
    } 
}