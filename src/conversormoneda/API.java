package conversormoneda;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import org.json.JSONObject;

public class API {
    
    public static void solicitudApiMonedas (String monedaOrigen, String monedaDestino, Double monto) throws IOException, InterruptedException{
        
        //Solicitud HTTP para la API
        String apiURL = "https://v6.exchangerate-api.com/v6/c00ba9ce0efa3f9e3cfecc28/latest/" + monedaOrigen;
        
         HttpClient client = HttpClient.newHttpClient();
         HttpRequest request = HttpRequest.newBuilder()
                     .uri(URI.create(apiURL))
                     .build();
         HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
         
         //Pasa la respuesta de la solicitud a un objeto JSON para obtener la información
         JSONObject jsonObject = new JSONObject(response.body());
         JSONObject tasasDivisa = jsonObject.getJSONObject("conversion_rates");
         Double tasa = tasasDivisa.getDouble(monedaDestino);
        
         //Realizar la conversion y formatea el resultado
         Double conversion = tasa*monto;
         BigDecimal conversionBD = new BigDecimal(conversion);
         conversionBD = conversionBD.setScale(2, RoundingMode.HALF_UP);
        
         System.out.println("**********************************************\n" +
                            "El monto ingresado corresponde a " + conversionBD.doubleValue() + " " + monedaDestino + "\n" +
                            "**********************************************");
    }
}
