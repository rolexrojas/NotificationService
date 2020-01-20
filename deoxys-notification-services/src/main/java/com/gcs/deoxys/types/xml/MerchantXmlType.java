package com.gcs.deoxys.types.xml;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="MERCHANT")
public class MerchantXmlType {

    private String telco;
    private String telephone;
    private String email;
    private String tpn;

    @XmlAttribute(name = "TELCO")
    public void setTelco(String telco) {
        this.telco = telco;
    }

    @XmlAttribute(name = "EMAIL")
    public void setEmail(String email) {
        this.email = email;
    }

    @XmlAttribute(name = "TELEPHONE")
    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    @XmlAttribute(name = "TPN")
    public void setTpn(String tpn) {
        this.tpn = tpn;
    }

    public String getTelco() {
        return telco;
    }

    public String getTelephone() {
        return telephone;
    }

    public String getEmail() {
        return email;
    }

    public String getTpn() {
        return tpn;
    }

    public MerchantXmlType(){}

    @Override
    public String toString() {
        return "MerchantXmlType{" +
                "telco='" + telco + '\'' +
                ", telephone='" + telephone + '\'' +
                ", email='" + email + '\'' +
                ", tpn='" + tpn + '\'' +
                '}';
    }
}
