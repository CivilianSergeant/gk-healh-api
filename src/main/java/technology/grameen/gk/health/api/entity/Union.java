package technology.grameen.gk.health.api.entity;

import javax.persistence.*;

@Entity
@Table(name = "lg_unions")
public class Union {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long unionId;
    private String unionCode;
    private Long thanaId;
    private String unionName;
    private String unionNameOther;
    private Boolean isRemoved;

    public Long getUnionId() {
        return unionId;
    }

    public void setUnionId(Long unionId) {
        this.unionId = unionId;
    }

    public String getUnionCode() {
        return unionCode;
    }

    public void setUnionCode(String unionCode) {
        this.unionCode = unionCode;
    }

    public Long getThanaId() {
        return thanaId;
    }

    public void setThanaId(Long thanaId) {
        this.thanaId = thanaId;
    }

    public String getUnionName() {
        return unionName;
    }

    public void setUnionName(String unionName) {
        this.unionName = unionName;
    }

    public String getUnionNameOther() {
        return unionNameOther;
    }

    public void setUnionNameOther(String unionNameOther) {
        this.unionNameOther = unionNameOther;
    }

    public Boolean getRemoved() {
        return isRemoved;
    }

    public void setRemoved(Boolean removed) {
        isRemoved = removed;
    }
}
