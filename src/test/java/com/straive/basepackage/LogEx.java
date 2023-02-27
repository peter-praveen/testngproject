package com.straive.basepackage;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LogEx {
	private static Logger logs=LogManager.getLogger(LogEx.class);
	
	public static void main(String[] args) {
		logs.debug("Dubug");
		logs.warn("Warning");
		logs.info("Info");
		logs.error("eRROR");
	}

}
