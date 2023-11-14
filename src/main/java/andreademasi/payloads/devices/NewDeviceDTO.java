package andreademasi.payloads.devices;

import andreademasi.entities.DeviceStatus;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record NewDeviceDTO(
        @NotEmpty(message = "Il nome del device è un campo obbligatorio!")
        @Size(min = 3, max = 20, message = "Il nome del device deve essere compreso tra 3 e 20 caratteri")
        String deviceName,

        DeviceStatus deviceStatus,
        @NotNull(message = "Lo user id e' obbligatorio")
        long userId
) {
}
