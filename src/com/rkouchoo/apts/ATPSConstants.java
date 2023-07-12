package com.rkouchoo.apts;

import java.util.Date;

public class ATPSConstants {
	
	/* 
	 * TODO: CLI implement these, used for testing
	 */
	
	public static double LAT = 33.9168;
	public static double LONG = 150.9830;

	public static String TLE_NETWORK_ADDRESS = "https://celestrak.org/NORAD/elements/gp.php?GROUP=noaa&FORMAT=json-pretty";
	
	public static String[] NOAA_SAT_IDENTIFIERS =
			{
					"1998-030A",
					"2005-018A",
					"2009-005A"
			};
	
	public static Date currentDate = new Date();
	public static String LATEST_TLE_NAME = String.format("%f_TLE.json", currentDate.getTime());  
	
}
