package za.co.crosstek.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;
import za.co.crosstek.anot.CoreAttribute;
import za.co.crosstek.anot.EntityAnotation;

@Entity
@EntityAnotation(attributes = {CoreAttribute.SHOW_ON_MENU, CoreAttribute.SINGLE_RECORD}, label = "Preference", icon = "fa fa-cog")
public class Preference extends CoreEntity {

    @OneToOne(cascade = CascadeType.REFRESH)
    @NotNull
    private Company company;

    @Override
    public String toString() {
        return "Pref";
    }
}
