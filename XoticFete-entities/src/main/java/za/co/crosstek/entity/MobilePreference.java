package za.co.crosstek.entity;

import javax.persistence.Entity;
import za.co.crosstek.anot.EntityAnotation;
import za.co.crosstek.enums.EntityAttribute;

@Entity
@EntityAnotation(attributes = {EntityAttribute.SINGLE_RECORD, EntityAttribute.REST}, label = "Mobile Preference", icon = "fa fa-building")
public class MobilePreference extends CoreEntity {

    @Override
    public String toString() {
        return "Mobile Pref";
    }
}
