package za.co.crosstek.entity;

import java.util.List;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.validation.constraints.NotNull;
import za.co.crosstek.anot.EntityAnotation;
import za.co.crosstek.anot.FieldAnotation;
import za.co.crosstek.enums.CoreAccessType;

@Entity
@EntityAnotation(label = "Core User", icon = "fa fa-user")
public class CoreAccess extends CoreEntity {

    @NotNull
    @Column(nullable = false)
    @FieldAnotation(label = "User")
    private CoreUser user;

    @Enumerated(EnumType.STRING)
    @ElementCollection(targetClass = CoreAccessType.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "access_types")
    @Column(name = "accesstype")
    @FieldAnotation(label = "Access Types")
    private List<CoreAccessType> accessTypes;

    @FieldAnotation(label = "Class Name", description = "This can be a class name or a page")
    private String className;

    public CoreUser getUser() {
        return user;
    }

    public void setUser(CoreUser user) {
        this.user = user;
    }

    public List<CoreAccessType> getAccessTypes() {
        return accessTypes;
    }

    public void setAccessTypes(List<CoreAccessType> accessTypes) {
        this.accessTypes = accessTypes;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    @Override
    public String toString() {
        return user.toString();
    }
}
