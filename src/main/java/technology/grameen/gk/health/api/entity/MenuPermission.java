package technology.grameen.gk.health.api.entity;

import javax.persistence.*;

@Entity
@Table(name = "menu_permissions")
public class MenuPermission {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String role;

    @ManyToOne
    private Menu menu;
}
