package com.rkouchoo.apts;

import java.time.Instant;

public class SatellitePass {
	
    private final Instant startTime;
    private final Instant endTime;
    private final double maxElevation;
    private final Instant maxElevationTime;

    public SatellitePass(Instant startTime, Instant endTime, double maxElevation, Instant maxElevationTime) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.maxElevation = maxElevation;
        this.maxElevationTime = maxElevationTime;
    }

    public Instant getStartTime() {
        return startTime;
    }

    public Instant getEndTime() {
        return endTime;
    }

    public double getMaxElevation() {
        return maxElevation;
    }

    public Instant getMaxElevationTime() {
        return maxElevationTime;
    }
}
