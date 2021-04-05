package technology.grameen.gk.health.api.resources.authserver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import technology.grameen.gk.health.api.network.HttpClient;
import technology.grameen.gk.health.api.projection.authserver.AdminAcessToken;
import technology.grameen.gk.health.api.projection.authserver.Role;
import technology.grameen.gk.health.api.responses.EntityCollectionResponse;
import technology.grameen.gk.health.api.responses.EntityResponse;
import technology.grameen.gk.health.api.responses.IResponse;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
@RequestMapping("/api/v1/roles")
public class RoleController {

    @Autowired
    private HttpClient httpClient;

    @GetMapping("")
    public ResponseEntity<IResponse> getRoles(){

        AdminAcessToken adminAccessToken = httpClient.getAdminAccessToken();
        List realmRoles = httpClient.getRealmRoles(adminAccessToken);
        List clientRoles = httpClient.getClientRoles(adminAccessToken);
        Stream<Object> combineResult = Stream.of(realmRoles,clientRoles).flatMap(Collection::stream);
        List<Object> combinedCollection = combineResult.collect(Collectors.toList());
        return new ResponseEntity<>(new EntityCollectionResponse<>(HttpStatus.OK.value(), combinedCollection),
                HttpStatus.OK);
    }
}
