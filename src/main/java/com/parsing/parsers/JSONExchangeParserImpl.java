package com.parsing.parsers;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.parsing.domain.ExchangeInfo;

import java.util.List;

public class JSONExchangeParserImpl implements ExchangeParser {

    private ObjectMapper objectMapper = new ObjectMapper();

    public List<ExchangeInfo> parse(String content) throws Exception {
        return objectMapper.readValue(content, new TypeReference<List<ExchangeInfo>>(){});
    }
}
