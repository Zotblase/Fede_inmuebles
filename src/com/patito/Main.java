package com.patito;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	    Scanner input = new Scanner(System.in);

        double precioTotal = 0;
        double cantidadDeInmuebles = 0;

        Inmueble inmuebleBase = new Inmueble();


        cargarInmuebles(inmuebleBase, input, precioTotal, cantidadDeInmuebles);
        System.out.println(calcularPromedio(precioTotal, cantidadDeInmuebles));
    }

    public static void cargarInmuebles(Inmueble inmuebleBase, Scanner input, double precioTotal, double cantidadDeInmuebles){
        while(true){
            System.out.println("Ingrese el código del inmueble o \"0\" para salir");
            inmuebleBase.codigo = input.nextInt();
            if (inmuebleBase.codigo == 0){
                break;
            }
            System.out.println("tipo: ");
            inmuebleBase.tipo = input.nextLine();
            input.next();
            try{
                System.out.println("cochera: ");
                inmuebleBase.cochera = input.nextBoolean();
            }catch (Exception InputMismatchException){
                System.out.println("Boludito, metiste mal las cosas");
                continue;
            }
            System.out.println("precio: ");
            inmuebleBase.precio = input.nextDouble();
            if (inmuebleBase.tipo.equals("casa") && inmuebleBase.cochera){
                precioTotal += inmuebleBase.precio;
                cantidadDeInmuebles++;
            }
        }
        System.out.println("Cargado con éxito");
    }

    public static double calcularPromedio(double precioTotal, double cantidadDeInmuebles){
        return (precioTotal/cantidadDeInmuebles);
    }
}
