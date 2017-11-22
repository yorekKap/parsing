package com.parsing.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="currency")
@XmlAccessorType(value = XmlAccessType.FIELD)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ExchangeInfo {
    private String txt;
    private Double rate;
    private String cc;


    public ExchangeInfo() {
    }

    public ExchangeInfo(String txt, Double rate, String cc) {
        this.txt = txt;
        this.rate = rate;
        this.cc = cc;
    }

    public String getTxt() {
        return txt;
    }

    public void setTxt(String txt) {
        this.txt = txt;
    }

    public Double getRate() {
        return rate;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }

    public String getCc() {
        return cc;
    }

    public void setCc(String cc) {
        this.cc = cc;
    }

    @Override
    public String toString() {
        return "ExchangeInfo{" +
                "txt='" + txt + '\'' +
                ", rate='" + rate + '\'' +
                ", cc='" + cc + '\'' +
                '}';
    }
}
