package technology.grameen.gk.health.api.services.menu;

import technology.grameen.gk.health.api.entity.Menu;

import java.util.List;

public interface MenuService {

    List<Menu> getAvailableMenus();

    List<Menu> getMenusByRole(String role);
}
