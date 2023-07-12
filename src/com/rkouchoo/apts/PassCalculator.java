package com.rkouchoo.apts;

import org.orekit.bodies.BodyShape;
import org.orekit.bodies.GeodeticPoint;
import org.orekit.bodies.OneAxisEllipsoid;
import org.orekit.data.DataProvidersManager;
import org.orekit.data.DirectoryCrawler;
import org.orekit.frames.*;
import org.orekit.propagation.SpacecraftState;
import org.orekit.propagation.analytical.tle.TLE;
import org.orekit.propagation.analytical.tle.TLEPropagator;
import org.orekit.time.AbsoluteDate;
import org.orekit.time.TimeScalesFactory;
import org.orekit.utils.*;

import java.io.File;
import java.time.Duration;
import java.time.Instant;

public class PassCalculator {

    public static String[] calculate(String[] tleData, double observerLatitude, double observerLongitude, int passCount) {
    	
    	// init the passes array
    	String[] passes = new String[]{};
    	
        // Set Orekit data file path
        File orekitDataPath = new File(ATPSConstants.ORE_DATA_PATH);
        
        DataProvidersManager manager = new DataProvidersManager();
        DirectoryCrawler crawler = new DirectoryCrawler(orekitDataPath);
        manager.addProvider(crawler);

        // Define the time range for the pass prediction
        Instant startTime = Instant.now();
        Instant endTime = startTime.plus(Duration.ofMinutes(10)); // Predict pass for 10 minutes

        // Create a TLE object, check if the data works before continuing 
        if (!TLE.isFormatOK(tleData[0], tleData[1])) {
        } else {
        	System.out.println("BAD TLE");
        	return null;
        }
        
    	TLE tle = new TLE(tleData[0], tleData[1]);
    	
    	System.out.println(tle.getElementNumber());
    	
    	/*
    	
    	
		// Create a TLE propagator
		TLEPropagator propagator = TLEPropagator.selectExtrapolator(tle);

		// Get the observer's frame
		Frame observerFrame = getObserverFrame(observerLatitude, observerLongitude);

		// Predict the satellite pass
		SatellitePass pass = predictPass(propagator, observerFrame, startTime, endTime);

		// Display the pass information
		System.out.println("Satellite Pass:");
		System.out.println("Start Time: " + pass.getStartTime());
		System.out.println("End Time: " + pass.getEndTime());
		System.out.println("Maximum Elevation: " + pass.getMaxElevation() + " degrees");
		System.out.println("Maximum Elevation Time: " + pass.getMaxElevationTime());
     
		
		*/
		
		
		
        return passes;
    }
    

    

    @SuppressWarnings("unused")
	private static Frame getObserverFrame(double observerLatitude, double observerLongitude) {
        // Define the observer's geodetic coordinates
        double observerAltitude = 0.0; // Observer is assumed to be at sea level
        GeodeticPoint observerPoint = new GeodeticPoint(observerLatitude, observerLongitude, observerAltitude);

        // Get the observer's frame using the WGS84 ellipsoid
        BodyShape earth = new OneAxisEllipsoid(Constants.WGS84_EARTH_EQUATORIAL_RADIUS, Constants.WGS84_EARTH_FLATTENING, FramesFactory.getITRF(IERSConventions.IERS_2010, true));
        return new TopocentricFrame(earth, observerPoint, "Observer");
    }
    

    @SuppressWarnings("unused")
	private static SatellitePass predictPass(TLEPropagator propagator, Frame observerFrame,
                                             Instant startTime, Instant endTime) {
        // Define the time step for the pass prediction (in seconds)
        double timeStep = 1.0;

        // Initialize the pass variables
        Instant currentTime = startTime;
        double maxElevation = Double.NEGATIVE_INFINITY;
        Instant maxElevationTime = null;

        // Iterate over the time range and predict the satellite pass
        while (currentTime.isBefore(endTime)) {
            // Convert the current time to Orekit's AbsoluteDate
        	AbsoluteDate currentDate = new AbsoluteDate(currentTime.toString(), TimeScalesFactory.getUTC());

            // Propagate the satellite state to the current time
            SpacecraftState state = propagator.propagate(currentDate);

            // Get the satellite's position in the observer's frame
            PVCoordinates pvCoordinates = observerFrame.getTransformTo(state.getFrame(), currentDate).transformPVCoordinates(state.getPVCoordinates());
            
            // Calculate the elevation angle (angle above the horizon)
            double elevation = Math.toDegrees(pvCoordinates.getPosition().getZ());

            // Update the maximum elevation if necessary
            if (elevation > maxElevation) {
                maxElevation = elevation;
                maxElevationTime = currentTime;
            }

            // Increment the current time by the time step
            currentTime = currentTime.plus(Duration.ofSeconds((long) timeStep));
        }

        return new SatellitePass(startTime, endTime, maxElevation, maxElevationTime);
    }

}

