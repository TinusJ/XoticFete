package za.co.crosstek.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;
import za.co.crosstek.anot.EntityAnotation;
import za.co.crosstek.anot.FieldAnotation;
import za.co.crosstek.enums.EntityAttribute;

@Entity
@EntityAnotation(attributes = { EntityAttribute.REST}, label = "Access Log", icon = "fa fa-eye")
public class AccessLog extends CoreEntity {

    @NotNull
    @FieldAnotation(label = "Remote Host")
    private String remoteHost;

    @Column(length = Short.MAX_VALUE)
    @FieldAnotation(label = "User Agent")
    private String userAgent;

    @FieldAnotation(label = "Remote Address")
    private String remoteAddress;

    @FieldAnotation(label = "WL Proxy IP")
    private String wlProxyClientIP;

    @FieldAnotation(label = "Proxy IP")
    private String proxyClientIP;

    @FieldAnotation(label = "Http IP")
    private String httpClientIP;

    @FieldAnotation(label = "F5 IP")
    private String f5IP;

    @OneToOne(cascade = CascadeType.REFRESH)
    @FieldAnotation(label = "Location")
    private GeoLocation location;

    public String getRemoteHost() {
        return remoteHost;
    }

    public void setRemoteHost(String remoteHost) {
        this.remoteHost = remoteHost;
    }

    public String getUserAgent() {
        return userAgent;
    }

    public void setUserAgent(String userAgent) {
        this.userAgent = userAgent;
    }

    public String getRemoteAddress() {
        return remoteAddress;
    }

    public void setRemoteAddress(String remoteAddress) {
        this.remoteAddress = remoteAddress;
    }

    public String getWlProxyClientIP() {
        return wlProxyClientIP;
    }

    public void setWlProxyClientIP(String wlProxyClientIP) {
        this.wlProxyClientIP = wlProxyClientIP;
    }

    public String getProxyClientIP() {
        return proxyClientIP;
    }

    public void setProxyClientIP(String proxyClientIP) {
        this.proxyClientIP = proxyClientIP;
    }

    public String getHttpClientIP() {
        return httpClientIP;
    }

    public void setHttpClientIP(String httpClientIP) {
        this.httpClientIP = httpClientIP;
    }

    public String getF5IP() {
        return f5IP;
    }

    public void setF5IP(String f5IP) {
        this.f5IP = f5IP;
    }

    public GeoLocation getLocation() {
        return location;
    }

    public void setLocation(GeoLocation location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return remoteHost;
    }
}
