package code.rest.curvitae;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

/**
 * Created by hernan on 28-04-14.
 */
public class RestClientVitae {

    public static final String URI_POST = "http://postulaciones.modernizacion.gob.cl/api/v1/postulaciones";
    public static final String IN_JSON =
        "{" +
        "\"nombre\": \"Hernán José\"," +
        "\"apellidos\": \"Aja Galindo\"," +
        "\"email\": \"hernan.aja@gmail.com\"," +
        "\"repo_url\": \"https://github.com/h3rnan\"," +
        "\"linkedin_url\": \"http://www.linkedin.com/in/hernanjose\"," +
        "\"cargo_a_postular\": \"Ingeniero área de desarrollo\"," +
        "\"respuesta_desafio\": \"MMMMM\"" +
        "}";
    public static void main(String[] args) {
        try {
            Client client = Client.create();
            WebResource webResource = client.resource(URI_POST);
            ClientResponse response = webResource.type("application/json")
                    .post(ClientResponse.class, IN_JSON);
            System.out.println("Output from Server .... \n");
            String output = response.getEntity(String.class);
            System.out.println(output + " -- code -- " + response.getStatus());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
