package com.yejh.log;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.classic.joran.JoranConfigurator;
import ch.qos.logback.core.util.StatusPrinter;

public class LogTest {
	private static Logger logger = LoggerFactory.getLogger(LogTest.class);

	public static void main(String[] args) {
		LoggerContext lc = (LoggerContext)LoggerFactory.getILoggerFactory();
		JoranConfigurator configurator = new JoranConfigurator();
		configurator.setContext(lc);
		lc.reset();
		try {
			configurator.doConfigure("src/main/resources/log/logback.xml");
		} catch (Exception e) {
			e.printStackTrace();
		}
		StatusPrinter.printInCaseOfErrorsOrWarnings(lc);
		System.out.println(logger.isDebugEnabled());
		logger.debug("debug");
		logger.info("info");
		logger.warn("warn");
		logger.error("error");
	}
}
