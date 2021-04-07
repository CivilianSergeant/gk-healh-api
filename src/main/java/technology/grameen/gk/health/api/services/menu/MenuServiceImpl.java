package technology.grameen.gk.health.api.services.menu;

import org.springframework.stereotype.Service;
import technology.grameen.gk.health.api.entity.Menu;
import technology.grameen.gk.health.api.repositories.MenuRepository;

import java.util.List;

@Service
public class MenuServiceImpl implements  MenuService{

    private  MenuRepository menuRepository;

    MenuServiceImpl(MenuRepository menuRepository){
        this.menuRepository = menuRepository;
    }

    @Override
    public List<Menu> getAvailableMenus() {
        return menuRepository.findAllOrderByDisplayOrderAsc();
    }

    @Override
    public List<Menu> getMenusByRole(String role) {
        return menuRepository.findByRole(role);
    }
}
