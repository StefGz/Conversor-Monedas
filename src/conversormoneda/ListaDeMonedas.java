package conversormoneda;

import java.util.HashMap;
import java.util.Map;

public class ListaDeMonedas {
  
    private static final Map<Integer, String> listaMonedas = new HashMap<>();

    static{
       
        listaMonedas.put(1, "ARS");
        listaMonedas.put(2, "BOB");
        listaMonedas.put(3, "BRL");
        listaMonedas.put(4, "CLP");
        listaMonedas.put(5, "COP");
        listaMonedas.put(6, "USD");
    }
    
    public static Map<Integer, String> obtenerListaMonedas() {
        return listaMonedas;
    }
}
