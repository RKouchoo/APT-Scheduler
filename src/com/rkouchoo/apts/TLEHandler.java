package com.rkouchoo.apts;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

import org.orekit.data.DataContext;
import org.orekit.files.ccsds.ndm.odm.omm.Omm;
import org.orekit.utils.IERSConventions;

import com.github.amsacode.predict4java.TLE;

public class TLEHandler {
	
/*
	private DEP_TLEInterpreter interpreter;
	private static String latestTLEName = ATPSConstants.LATEST_TLE_NAME; // keep track of the latest tle file name when init, we need it later.
	// need to implement a string to be able to ref a previously cached tle file
*/
	
    public static String[] retrieveTLEData(String tleUrl) throws IOException {
        StringBuilder tleData = new StringBuilder();

        // Read TLE data from the provided URL
        URL url = new URL(tleUrl);
        BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
        String line;
        while ((line = reader.readLine()) != null) {
            tleData.append(line).append("\n");
        }
        reader.close();

        // Split the TLE data into separate lines
        String[] tleLines = tleData.toString().split("\n");

        return tleLines;
    }
    

    
    // download an OMM html file and return a TLE object
    public static TLE getTLEFromOMM(String tleOmmUrl) throws MalformedURLException, IOException {
        StringBuilder tleData = new StringBuilder();

        // Read TLE data from the provided URL
        URL url = new URL(tleOmmUrl);
        BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
        String line;
        
        while ((line = reader.readLine()) != null) {
            tleData.append(line).append("\n");
        }
      
        reader.close();
    	
    	String OMMXML = tleData.toString();
    	
    	//Omm omm = new Omm(OMMXML, IERSConventions.IERS_2010, null);
    	//omm.generateTLE();
    	
    	
    	
    	return null;
    }
    
    
}


