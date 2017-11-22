package com.parsing.parsers;

import com.parsing.domain.ExchangeInfo;
import com.parsing.domain.ExchangeInfos;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import java.io.StringReader;
import java.util.List;

public class JAXBExchangeParserImpl implements ExchangeParser {

    public List<ExchangeInfo> parse(String content) throws Exception {
        JAXBContext context = JAXBContext.newInstance(ExchangeInfos.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();

        return ((ExchangeInfos) unmarshaller.unmarshal(new StringReader(content)))
                .getExchangeInfoList();
    }
}
