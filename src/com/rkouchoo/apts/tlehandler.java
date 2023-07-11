package com.rkouchoo.apts;

import java.io.FileOutputStream;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;

public class tlehandler {

	private tleinterpreter interpreter;

	
	private void GetLatestTLE(String tleDownload) {
		
		URL tleWebsite = new URL(tleDownload);
		ReadableByteChannel rbc = Channels.newChannel(tleWebsite.openStream());
		FileOutputStream fos = new FileOutputStream("information.html");
		fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);
		
		
	}
	

}
