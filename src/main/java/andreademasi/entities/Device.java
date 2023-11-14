package andreademasi.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Device {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "device_id")
    private long deviceId;
    @Column(name = "device_name")
    private String deviceName;
    @Enumerated(EnumType.STRING)
    @Column(name = "device_status")
    private DeviceStatus deviceStatus;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Device(String deviceName, DeviceStatus deviceStatus, User user) {
        this.deviceName = deviceName;
        this.deviceStatus = deviceStatus;
        this.user = user;
    }
}
