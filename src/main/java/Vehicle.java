import javax.persistence.*;

@Entity
public class Vehicle {
    @Id
    @GeneratedValue
    private int vehicleID;
    private String vehicleName;

    @ManyToOne
    @JoinColumn(name = "USER_ID")
    private UserDetails user;

    public UserDetails getUser() {
        return user;
    }

    public void setUser(UserDetails user) {
        this.user = user;
    }

    public String getVehicleName() {
        return vehicleName;
    }

    public void setVehicleName(String vehicleName) {
        this.vehicleName = vehicleName;
    }

    public int getVehicleID() {
        return vehicleID;
    }

    public void setVehicleID(int vehicleID) {
        this.vehicleID = vehicleID;
    }
}
