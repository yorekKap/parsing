package com.parsing;

import com.parsing.domain.ExchangeInfo;
import com.parsing.parsers.*;
import com.parsing.tools.GetRequestContentFetcher;

import java.util.List;

public class MinfinParser {
    private static final String JSON_MINFIN_EXCHANGE_URL =
            "https://bank.gov.ua/NBUStatService/v1/statdirectory/exchange?json";

    private static final String XML_MINFIN_EXCHANGE_URL =
            "https://bank.gov.ua/NBUStatService/v1/statdirectory/exchange";

    private static final String HTML_MINFIN_EXCHANGE_URL =
            "http://index.minfin.com.ua/exch/";

    private GetRequestContentFetcher getRequestContentFetcher = new GetRequestContentFetcher();

    public void parse(){
        try {
            System.out.println("---JSON PARSING---");
            doJSONParsing();

            System.out.println("\n---JAXB PARSING---");
            doJAXBParsing();

            System.out.println("\n---DOM PARSING---");
            doDOMParsing();

            System.out.println("\n---JSOUP PARSING---");
            doJSOUPParsing();

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private void doJSONParsing()throws Exception{
        ExchangeParser jsonExchangeParser = new JSONExchangeParserImpl();
        String content = getRequestContentFetcher.getContent(JSON_MINFIN_EXCHANGE_URL);

        List<ExchangeInfo> exchangeInfoList = jsonExchangeParser.parse(content);

        printExchangeInfoList(exchangeInfoList);

    }

    private void doJAXBParsing()throws Exception{
        ExchangeParser jaxbExchangeParser = new JAXBExchangeParserImpl();
        String content = getRequestContentFetcher.getContent(XML_MINFIN_EXCHANGE_URL);

        List<ExchangeInfo> exchangeInfoList = jaxbExchangeParser.parse(content);

        printExchangeInfoList(exchangeInfoList);
    }

    private void doDOMParsing() throws Exception {
        ExchangeParser domExchangeParser = new DOMExchangeParserImpl();
        String content = getRequestContentFetcher.getContent(XML_MINFIN_EXCHANGE_URL);

        List<ExchangeInfo> exchangeInfoList = domExchangeParser.parse(content);

        printExchangeInfoList(exchangeInfoList);
    }

    private void doJSOUPParsing() throws Exception {
        ExchangeParser jsoupExchangeParser = new JSOUPExchangeParserImpl();
        String content = getRequestContentFetcher.getContent(HTML_MINFIN_EXCHANGE_URL);

        List<ExchangeInfo> exchangeInfoList = jsoupExchangeParser.parse(content);

        printExchangeInfoList(exchangeInfoList);
    }


    private void printExchangeInfoList(List<ExchangeInfo> exchangeInfoList) {
        for(ExchangeInfo exchangeInfo : exchangeInfoList){
            System.out.println(exchangeInfo);
        }
    }

}
