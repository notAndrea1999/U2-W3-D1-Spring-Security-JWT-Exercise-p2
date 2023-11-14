package andreademasi.entities;

import java.util.Random;

public enum DeviceStatus {
    DISPONIBILE, ASSEGANTO, IN_MANUTENZIONE, DISMESSO;
    private static final Random rndm = new Random();

    public static DeviceStatus randomDeviceStatus() {
        DeviceStatus[] devices = values();
        return devices[rndm.nextInt(devices.length)];
    }
}
