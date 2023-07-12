# APT-Scheduler 
A small project to schedule APT reception on my home weatherstation
Other instances such as https://github.com/jekhokie/raspberry-noaa-v2 exist but are only compatible with certain devices and trying to hack their implementation causes more problems than fixes.
This has been developed to work on an OPI5 & RPI 4
Complied as a Jar file - will allow it to be run on ARMHF and other devices you can get java running on 

## Requirements
- RTL-SDR binaries compiled for your system
- NOAA-APT binaries compiled for your system
- Periodic internet access to download path data

## TODO:
- Implement scheduler
- Determine OS version, run correct binaries
- Doppler shift (need to see how possible this is with RTL-SDR drivers) 
- Maybe hook onto GQRX native libs
