package JerseyClients;

import javax.ws.rs.ClientErrorException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import org.glassfish.jersey.client.authentication.HttpAuthenticationFeature;

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

    /**
     * Constructor que registra Basic Auth en el cliente.
     * Todas las peticiones llevarán la cabecera Authorization: Basic ...
     */
    public OrganizacionJerseyClient(String username, String password) {
        HttpAuthenticationFeature feature = HttpAuthenticationFeature.basic(username, password);
        client = ClientBuilder.newClient().register(feature);
        webTarget = client.target(BASE_URI).path("models.organizaciones");
    }

    /**
     * GET /models.organizaciones/{id} en XML
     * @param <T>          tipo de retorno (por ejemplo, Organizaciones.class)
     * @param responseType clase de la respuesta
     * @param id           cadena con el idOrganizacion (p. ej. "3")
     * @return instancia de T (Organizaciones) si existe
     * @throws ClientErrorException si hay un error HTTP (ej. 404)
     */
    public <T> T find_XML(Class<T> responseType, String id) throws ClientErrorException {
        WebTarget resource = webTarget.path(id);
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_XML).get(responseType);
    }

    /**
     * GET /models.organizaciones/{id} en JSON
     */
    public <T> T find_JSON(Class<T> responseType, String id) throws ClientErrorException {
        WebTarget resource = webTarget.path(id);
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    // (Opcional) Métodos para create, edit, remove, findAll… 
    // Si no los necesitas para el login, puedes omitirlos.

    public void close() {
        client.close();
    }
}
