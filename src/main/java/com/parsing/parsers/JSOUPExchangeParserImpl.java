package com.parsing.parsers;

import com.parsing.domain.ExchangeInfo;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;

public class JSOUPExchangeParserImpl implements ExchangeParser {

    private static final int TXT_INDEX = 3;
    private static final int CC_INDEX = 1;
    private static final int RATE_INDEX = 4;
    private static final int NUM_OF_CURRENCY_INDEX = 2;

    public List<ExchangeInfo> parse(String content) throws Exception {
        Document document = Jsoup.parse(content);

        //we are selecting trs only from the first table
        Elements tableRows = document.select("table.zebra")
                .get(0)
                .select("tbody tr");

        List<ExchangeInfo> exchangeInfoList = new ArrayList<>();

        //first row is headers
        for (int i = 1; i < tableRows.size(); i++) {
            Elements row = tableRows.get(i).select("td");

            String txt = row.get(TXT_INDEX).text();
            String cc = row.get(CC_INDEX).text();

            Integer numOfCurrency = Integer.valueOf(row.get(NUM_OF_CURRENCY_INDEX).text());
            String rateStr = row.get(RATE_INDEX)
                    .text()
                    .replace(",", ".");

            Double rate = Double.valueOf(rateStr) / numOfCurrency;

            exchangeInfoList.add(new ExchangeInfo(txt, rate, cc));
        }

        return exchangeInfoList;
    }

}
