package com.parsing.domain;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name="exchange")
@XmlAccessorType(value = XmlAccessType.FIELD)
public class ExchangeInfos {

    @XmlElement(name = "currency")
    private List<ExchangeInfo> exchangeInfoList = new ArrayList<>();

    public List<ExchangeInfo> getExchangeInfoList() {
        return exchangeInfoList;
    }

    public void setExchangeInfoList(List<ExchangeInfo> exchangeInfoList) {
        this.exchangeInfoList = exchangeInfoList;
    }
}
