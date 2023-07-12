package com.rkouchoo.apts;

import com.rkouchoo.apts.PassCalculator;

import java.io.IOException;

import com.rkouchoo.apts.ATPSConstants;
import com.rkouchoo.apts.TLEHandler;

public class Main {

	public static void main(String[] args) throws IOException {
		
		String[] latestTLE = TLEHandler.retrieveTLEData(ATPSConstants.TLE_NETWORK_ADDRESS);
		
		for (int i = 0; i < 6; i++) {
			System.out.println(latestTLE[i]);
		}
	
		String[] passes = PassCalculator.calculate(latestTLE, ATPSConstants.LAT, ATPSConstants.LONG, 1);
		
		
	}

}
