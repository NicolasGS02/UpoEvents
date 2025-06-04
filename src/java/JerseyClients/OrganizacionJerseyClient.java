package JerseyClients;

import javax.ws.rs.ClientErrorException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;


/**
 * Jersey REST client para el recurso OrganizacionesFacadeREST [models.organizaciones].
 *
 * Hay dos constructores:
 *   - OrganizacionJerseyClient(): sin autenticación.
 *   - OrganizacionJerseyClient(username, password): con Basic Auth en todas las peticiones.
 */
public class OrganizacionJerseyClient {

    private WebTarget webTarget;
    private Client client;
    // Ajusta esta URL si tu contexto no es “UpoEvents”
    private static final String BASE_URI = "http://localhost:8080/UpoEvents/webresources";

    /**
     * Constructor por defecto (sin autenticación).
     */
    public OrganizacionJerseyClient() {
        client = ClientBuilder.newClient();
        webTarget = client.target(BASE_URI).path("models.organizaciones");
    }

   
    
    public <T> T find_XML(Class<T> responseType, String id) throws ClientErrorException {
        WebTarget resource = webTarget.path(id);
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_XML).get(responseType);
    }

   
    public <T> T find_JSON(Class<T> responseType, String id) throws ClientErrorException {
        WebTarget resource = webTarget.path(id);
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

   

    public void close() {
        client.close();
    }
}
