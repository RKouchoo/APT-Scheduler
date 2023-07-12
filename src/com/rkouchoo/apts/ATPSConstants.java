package com.rkouchoo.apts;

import java.util.Date;

public class ATPSConstants {
	
	/* 
	 * TODO: CLI implement these, used for testing
	 */
	
	public static double LAT = 33.9168;
	public static double LONG = 150.9830;

	public static String TLE_NETWORK_ADDRESS = "https://celestrak.org/NORAD/elements/gp.php?GROUP=noaa&FORMAT=csv";
	public static String TLE_NETWORK_OMM_ADDRESS = "https://celestrak.org/NORAD/elements/gp.php?GROUP=noaa&FORMAT=OMM";
	public static String ORE_DATA_PATH = "./orekit";
	
	public static String[] NOAA_SAT_IDENTIFIERS =
			{
					"1998-030A",
					"2005-018A",
					"2009-005A"
			};
	
	public static Date currentDate = new Date();
	
}
