package technology.grameen.gk.health.api.network;

import org.springframework.http.ResponseEntity;
import technology.grameen.gk.health.api.projection.authserver.AdminAcessToken;
import technology.grameen.gk.health.api.projection.authserver.Role;

import java.util.List;
import java.util.Map;

public interface HttpClient {

    AdminAcessToken getAdminAccessToken();

    List<Object> getRealmRoles(AdminAcessToken token);

    List<Object> getClientRoles(AdminAcessToken token);
}
