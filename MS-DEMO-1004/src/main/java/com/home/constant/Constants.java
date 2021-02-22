package com.home.constant;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Constants {
	private static final Logger LOGGER = LoggerFactory.getLogger(Constants.class);
	public static final String SUCCESS = "200";
	public static final String ERROR = "300";
	public static final int ONE = 1;
	public static final int ZERO = 0;

	private Constants() {
		LOGGER.info("Constants class no-arg-constractor.");
	}

}
