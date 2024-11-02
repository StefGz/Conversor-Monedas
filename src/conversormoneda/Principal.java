package conversormoneda;

import java.io.IOException;
import java.util.Map;
import java.util.Scanner;

public class Principal {

    public static void main(String[] args) throws IOException, InterruptedException {
      
        Scanner sc = new Scanner(System.in);
   
        boolean continuar = true;
    
        while(continuar){
        System.out.println("""
                           ************************************
                           ¡Bienvenido al conversor de monedas!
                           ************************************
                           """);   
        
        //Obtener lista de monedas    
        Map<Integer, String> listaMonedas = ListaDeMonedas.obtenerListaMonedas();
        
        //Variables para la operación de conversión 
        String monedaOrigen, monedaDestino;
        Double monto;
        
        //Menú
        Menu menu = new Menu();
        int opcionMenu;
        
        //Menú para moneda de origen
        menu.mostrarMenu();
        opcionMenu = sc.nextInt();
  
        while(opcionMenu <1 || opcionMenu > 6){
           System.out.println("""
                              ************************************
                              Opción no valida, inténtelo de nuevo
                              ************************************
                              """);
           opcionMenu = sc.nextInt();
        }
    
        monedaOrigen = listaMonedas.get(opcionMenu);
        
        //Menú para moneda de destino
        menu.mostrarMenu();
        opcionMenu = sc.nextInt();
        
         while(opcionMenu <1 || opcionMenu > 6){
           System.out.println("""
                              ************************************
                              Opción no valida, inténtelo de nuevo
                              ************************************
                              """);
           opcionMenu = sc.nextInt();
        }
        
        monedaDestino = listaMonedas.get(opcionMenu);
        
       //Solicitud cantidad de dinero para la conversión
       System.out.println("""
                          *************************************************
                          Ingrese la cantidad de dinero que desea convertir
                          *************************************************
                          """);
       monto = sc.nextDouble();
       
       //Solicitud para la API
       API.solicitudApiMonedas(monedaOrigen, monedaDestino, monto);
       
       //Pregunta si desea realizar una nueva consersión
       System.out.println("""
                          **************************************************************************
                          ¿Desea realizar otra conversión? Elija el número correspondiente 1:Sí/2:No
                          **************************************************************************
                          """);
       int respuesta = sc.nextInt();
       
       if(respuesta == 2){
           System.out.println("""
                              ******************************************
                              ¡Gracias por usar el conversor de monedas!
                              ******************************************
                              """);
           continuar = false;
        }
       
      }
       
    }
}
