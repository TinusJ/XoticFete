package za.co.crosstek.entity;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

@Entity
public class Wallet extends CoreEntity {

    private Integer emailCount;

    private Integer smsCount;

    private Integer notificationCount;

    @Transient
    private String qrcode;

    @OneToMany(mappedBy = "wallet", cascade = CascadeType.REFRESH)
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
