package com.gcs.deoxys.types.xml;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name="MERCHANTS")
public class MerchantListXmlType {

    private List<MerchantXmlType> listMerchants;

    public List<MerchantXmlType> getListMerchants() {
        return listMerchants;
    }

    @XmlElement(name = "MERCHANT")
    public void setListMerchants(List<MerchantXmlType> listmerchants) {
        this.listMerchants = listmerchants;
    }

    @Override
    public String toString() {
        return "MerchantListXmlType{" +
                "listMerchants=" + listMerchants +
                '}';
    }
}
