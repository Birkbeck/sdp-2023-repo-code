package bridge;

// Concrete Implementor

// Here is an implementation of the EntertainmentDevice
// abstract class. I'm specifying what makes it different
// from other devices

public class DVDDevice extends EntertainmentDevice {

    public DVDDevice(int deviceState, int maxSetting) {
        super(deviceState, maxSetting);
    }

    public void buttonFivePressed() {
        System.out.println("DVD Skips to Chapter");
        deviceState--;
    }

    public void buttonSixPressed() {
        System.out.println("DVD Skips to Next Chapter");
        deviceState++;
    }
}