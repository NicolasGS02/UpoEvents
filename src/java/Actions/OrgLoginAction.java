package Actions;

import JerseyClients.OrganizacionJerseyClient;
import Models.Organizaciones;
import com.opensymphony.xwork2.ActionSupport;


/**
 * OrgLoginAction: autentica a una organización recibiendo el ID como String.
 */
public class OrgLoginAction extends ActionSupport {

    // Recibimos el ID como String
    private String orgId;
    private String orgPassword;
    private Organizaciones organizacion = null;

    @Override
    public String execute() {
        // 1) Validar que el campo orgId no esté vacío
        if (orgId == null || orgId.trim().isEmpty()) {
            addActionError("Debe indicar el ID de la organización.");
            return ERROR;
        }

        // 2) Verificar que orgId sea un número válido > 0
        int idNum;
        try {
            idNum = Integer.parseInt(orgId.trim());
            if (idNum <= 0) {
                addActionError("El ID de la organización debe ser un número positivo.");
                return ERROR;
            }
        } catch (NumberFormatException ex) {
            addActionError("El ID de la organización debe ser un número válido.");
            return ERROR;
        }

        // 3) Validar la contraseña no vacía
        if (orgPassword == null || orgPassword.trim().isEmpty()) {
            addActionError("Debe introducir la contraseña.");
            return ERROR;
        }

        // 4) Llamar al servicio REST para obtener la organización
        OrganizacionJerseyClient client = new OrganizacionJerseyClient();

            // Pasamos directamente el String “orgId” al método find_XML
            this.organizacion = client.find_XML(Organizaciones.class, orgId.trim());
            


        // 5) Comparar la contraseña
        if (!organizacion.getPassword().equals(orgPassword)) {
            addActionError("Contraseña incorrecta.");
            return ERROR;
        }
        
        client.close();

        // 6) Login exitoso
        return SUCCESS;
    }

    // Getters / Setters
    public String getOrgId() {
        return orgId;
    }
    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }

    public String getOrgPassword() {
        return orgPassword;
    }
    public void setOrgPassword(String orgPassword) {
        this.orgPassword = orgPassword;
    }

    public Organizaciones getOrganizacion() {
        return organizacion;
    }
    public void setOrganizacion(Organizaciones organizacion) {
        this.organizacion = organizacion;
    }
}
