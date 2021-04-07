package technology.grameen.gk.health.api.requests;

import technology.grameen.gk.health.api.entity.MenuPermission;

import java.util.Set;

public class RolePermission {
    Set<MenuPermission> permissions;

    public Set<MenuPermission> getPermissions() {
        return permissions;
    }

    public void setPermissions(Set<MenuPermission> permissions) {
        this.permissions = permissions;
    }
}
