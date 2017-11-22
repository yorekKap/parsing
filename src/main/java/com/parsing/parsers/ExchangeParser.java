package com.parsing.parsers;

import com.parsing.domain.ExchangeInfo;

import java.util.List;

public interface ExchangeParser {
    List<ExchangeInfo> parse(String content)throws Exception;
}
