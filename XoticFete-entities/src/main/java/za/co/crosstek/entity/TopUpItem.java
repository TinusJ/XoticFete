package za.co.crosstek.entity;

import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import za.co.crosstek.anot.EntityAnotation;
import za.co.crosstek.anot.FieldAnotation;
import za.co.crosstek.enums.EntityAttribute;
import za.co.crosstek.enums.FieldExclusion;
import za.co.crosstek.enums.TopUpType;

@Entity
@EntityAnotation(label = "Top Up", icon = "fa fa-credit-card")
public class TopUpItem extends CoreEntity {

    @ManyToOne
    @NotNull
    @FieldAnotation(label = "Wallet")
    private Wallet wallet;

    @Enumerated(EnumType.STRING)
    @NotNull
    @Column(nullable = false)
    @FieldAnotation(label = "Type")
    private TopUpType type;

    @NotNull
    @Column(nullable = false)
    @FieldAnotation(label = "Ammount")
    private Integer ammount;

    @NotNull
    @Column(nullable = false)
    @FieldAnotation(label = "Total Cost")
    private Double totalCost;

    @FieldAnotation(label = "Promotional")
    private Boolean promotional;

    @NotNull
    @Column(nullable = false)
    @FieldAnotation(label = "Purchase UUID", exclusions = {FieldExclusion.EDITABLE, FieldExclusion.FORM})
    private UUID purchaseUUID;

    public Wallet getWallet() {
        return wallet;
    }

    public void setWallet(Wallet wallet) {
        this.wallet = wallet;
    }

    public TopUpType getType() {
        return type;
    }

    public void setType(TopUpType type) {
        this.type = type;
    }

    public Integer getAmmount() {
        return ammount;
    }

    public void setAmmount(Integer ammount) {
        this.ammount = ammount;
    }

    public Double getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(Double totalCost) {
        this.totalCost = totalCost;
    }

    public UUID getPurchaseUUID() {
        return purchaseUUID;
    }

    public void setPurchaseUUID(UUID purchaseUUID) {
        this.purchaseUUID = purchaseUUID;
    }

    public Boolean getPromotional() {
        return promotional;
    }

    public void setPromotional(Boolean promotional) {
        this.promotional = promotional;
    }

    @Override
    public String toString() {
        return type + "(" + ammount + ")";
    }
}
