package com.twojmod.megautobuyer.auction.scanner;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class PriceParser {
    private static final List<Pattern> DEFAULT_PATTERNS = List.of(
            Pattern.compile("(?:Cena|Price|Koszt)\\s*[:：]\\s*([0-9][0-9\\s,.]*)", Pattern.CASE_INSENSITIVE),
            Pattern.compile("([0-9][0-9\\s,.]*)\\s*(?:coins|coin|zł)", Pattern.CASE_INSENSITIVE)
    );

    public int parse(List<String> lines) {
        for (String line : lines) {
            for (Pattern pattern : DEFAULT_PATTERNS) {
                Matcher matcher = pattern.matcher(line);
                if (matcher.find()) {
                    String normalized = matcher.group(1).replaceAll("[^0-9]", "");
                    if (!normalized.isEmpty()) {
                        return Integer.parseInt(normalized);
                    }
                }
            }
        }
        return -1;
    }
}
