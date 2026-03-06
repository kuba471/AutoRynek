package com.twojmod.megautobuyer.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class ModLogger {
    private static final Logger LOGGER = LoggerFactory.getLogger("MegaAutoBuyer");

    private ModLogger() {}

    public static void info(String message) { LOGGER.info(message); }
    public static void error(String message, Throwable throwable) { LOGGER.error(message, throwable); }
}
