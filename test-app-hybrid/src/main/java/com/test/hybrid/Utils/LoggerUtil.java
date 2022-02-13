package com.test.hybrid.Utils;

import org.apache.log4j.Logger;

public class LoggerUtil {
	public static Logger logger;
	
	public LoggerUtil() {
		LoggerUtil.logger = Logger.getLogger(LoggerUtil.class);
	}
}
