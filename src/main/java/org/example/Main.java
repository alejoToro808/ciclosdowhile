package org.example;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //DECLARANDO VARIABLES
        Scanner teclado= new Scanner(System.in);
        Random aleatorio=new Random();

        Boolean administrador;
        String respuestaDelPerfil;
        Double tarifaEnergia;
        Integer opcion;
        String contraseñaUsuario;
        Integer contadorEnergia=0;
        final String contraseña="admin123";

        System.out.println("**BIENVENIDO**");
        System.out.print("Eres administrador: ");
        respuestaDelPerfil=teclado.nextLine();

        //PROCESO PARA EL LOGIN

        if (respuestaDelPerfil.equalsIgnoreCase("Si")){
            System.out.print("Digita tu contraseña: ");
            contraseñaUsuario=teclado.nextLine();
            //COMPARAMOS LA CONTRASEÑA CON LA CONSTANTE ALMACENADA
            if (contraseñaUsuario.equals(contraseña)){

                //FELICITACIONES, USTRED ES ADMINISTRADOR
                System.out.println("Usted es un admin");

                //PUEDO ACTUALIZAR LA TARIFA DE ENERGIA
                System.out.print("Ingresa el valor del KWH: ");
                tarifaEnergia=teclado.nextDouble();
                System.out.println("La tarifa de energia quedo en: $ "+tarifaEnergia);
                Integer numeroVueltas=0; //CONTADOR
                Integer contadorDePicos=0;
                do {
                    numeroVueltas=numeroVueltas+1;
                    Integer numeroGenerado=aleatorio.nextInt(400)+1;
                    contadorEnergia=contadorEnergia+numeroGenerado;

                    if (numeroGenerado>300){
                        System.out.println("Pico detectado");
                        contadorDePicos=contadorDePicos+1;
                    }else{
                        System.out.println("Operando normalmente");
                    }
                }while (numeroVueltas<30);
                System.out.println(numeroVueltas);
                System.out.println(contadorDePicos);

                //MENU
                System.out.println("1. Ver tarifa");
                System.out.println("2. Mostrar consumo promedio");
                System.out.println("3. Mostrar consumo picos");
                System.out.println("4. Mostrar factura");
                System.out.println("5. Salir");

                //REPITIENDO MENU
                do {
                    System.out.print("Apreciado cliente, digita una opcion: ");
                    opcion=teclado.nextInt();

                    switch (opcion){
                        case 1:
                            System.out.println("La tarifa KWH es: " +tarifaEnergia);
                            break;
                        case 2:
                            System.out.println("El consumo total fue: "+contadorEnergia);
                            Double promedioConsumo=contadorEnergia/30.0;
                            System.out.println("El consumo promedio es: "+promedioConsumo);
                            break;

                        case 3:
                            System.out.println("La cantidad de picos fue: "+contadorDePicos);
                            break;

                        case 4:
                            System.out.println("El resumen de tu factura es: ");
                            Double totalPagar=contadorEnergia*tarifaEnergia;
                            System.out.println("$....."+totalPagar);
                            break;
                        default:
                            System.out.println("Opcion invalida");
                            break;
                    }

                }while (opcion!=5);


                
            }else{
                System.out.println("Usted es un sapo hpta");
            }

        }else{
            System.out.println("usted es una empresa");
        }



    }
}