package za.co.crosstek.entity;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import za.co.crosstek.anot.EntityAnotation;
import za.co.crosstek.anot.FieldAnotation;
import za.co.crosstek.enums.EntityAttribute;
import za.co.crosstek.enums.FieldExclusion;
import za.co.crosstek.enums.FieldType;

@Entity
@EntityAnotation(attributes = {EntityAttribute.SHOW_ON_MENU, EntityAttribute.SINGLE_RECORD}, label = "Wallet", icon = "fa fa-google-wallet")
public class Wallet extends CoreEntity {

    @FieldAnotation(label = "Emails", exclusions = {FieldExclusion.EDITABLE, FieldExclusion.FORM})
    private Integer emailCount;

    @FieldAnotation(label = "SMSse", exclusions = {FieldExclusion.EDITABLE, FieldExclusion.FORM})
    private Integer smsCount;

    @FieldAnotation(label = "Notifcaitons", exclusions = {FieldExclusion.EDITABLE, FieldExclusion.FORM})
    private Integer notificationCount;

    @FieldAnotation(label = "QR CODE", exclusions = {FieldExclusion.EDITABLE, FieldExclusion.FORM}, type = FieldType.QRCODE)
    private String qrcode;

    @OneToMany(mappedBy = "wallet", cascade = CascadeType.REFRESH)
    @FieldAnotation(label = "Top Ups")
    private List<TopUpItem> topups;

    public Integer getEmailCount() {
        return emailCount;
    }

    public void setEmailCount(Integer emailCount) {
        this.emailCount = emailCount;
    }

    public Integer getSmsCount() {
        return smsCount;
    }

    public void setSmsCount(Integer smsCount) {
        this.smsCount = smsCount;
    }

    public Integer getNotificationCount() {
        return notificationCount;
    }

    public void setNotificationCount(Integer notificationCount) {
        this.notificationCount = notificationCount;
    }

    public String getQrcode() {
        return qrcode;
    }

    public void setQrcode(String qrcode) {
        this.qrcode = qrcode;
    }

    public List<TopUpItem> getTopups() {
        return topups;
    }

    public void setTopups(List<TopUpItem> topups) {
        this.topups = topups;
    }

    @Override
    public String toString() {
        return super.getCompany().getCompanyName() + " - Wallet";
    }
}
