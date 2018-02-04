package za.co.crosstek.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

@Entity
public class Preference extends CoreEntity {

    @OneToOne(cascade = CascadeType.REFRESH)
    @NotNull
    private Company company;

    @Override
    public String toString() {
        return "Pref";
    }
}
