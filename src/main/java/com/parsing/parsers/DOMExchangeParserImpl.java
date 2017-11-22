package com.parsing.parsers;

import com.parsing.domain.ExchangeInfo;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.List;

public class DOMExchangeParserImpl implements ExchangeParser {

    @Override
    public List<ExchangeInfo> parse(String content) throws Exception {
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.parse(new ByteArrayInputStream(content.getBytes()));

        doc.getDocumentElement().normalize();

        NodeList nodeList = doc.getElementsByTagName("currency");
        List<ExchangeInfo> exchangeInfoList = new ArrayList<>();
        for(int i = 0; i < nodeList.getLength(); i++){
            ExchangeInfo exchangeInfo = new ExchangeInfo();
            Element element = (Element) nodeList.item(i);

            exchangeInfo.setTxt(element.getElementsByTagName("txt")
                    .item(0)
                    .getTextContent());

            exchangeInfo.setCc(element.getElementsByTagName("cc")
                    .item(0)
                    .getTextContent());

            Double rate = Double.valueOf(element.getElementsByTagName("rate")
                    .item(0)
                    .getTextContent());

            exchangeInfo.setRate(rate);

            exchangeInfoList.add(exchangeInfo);
        }

        return exchangeInfoList;
    }
}
