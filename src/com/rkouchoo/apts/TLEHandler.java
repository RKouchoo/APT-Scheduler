package com.rkouchoo.apts;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class TLEHandler {

	private TLEInterpreter interpreter;
	private static String latestTLEName = ATPSConstants.LATEST_TLE_NAME; // keep track of the latest tle file name when init, we need it later.
	// need to implement a string to be able to ref a previously cached tle file
	
	private void getLatestTLE(String tleDownload) throws MalformedURLException, IOException {
		InputStream in = new URL(tleDownload).openStream();
		Files.copy(in, Paths.get(latestTLEName), StandardCopyOption.REPLACE_EXISTING);
	}
	
	
	public void predictNextPasses(String sat, InputStream TLE, int passAmount, long lat, long longn) throws IOException {
		interpreter.importSat(TLE);

		
		
	}

}


