import org.hibernate.annotations.CollectionId;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;


import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "USER_DETAILS")
public class UserDetails {


    private int userId;


    private String username;

    private Collection<Vehicle> vehicleCollection = new ArrayList<Vehicle>();


    @OneToMany(mappedBy = "user")
    public Collection<Vehicle> getVehicle() {
        return vehicleCollection;
    }

    public void setVehicle(Collection<Vehicle> vehicle) {
        this.vehicleCollection = vehicle;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "USER_ID")
    public int getUserId() {
        return userId;
    }


    public void setUserId(int userId) {
        this.userId = userId;
    }


    @Column(name = "USER_NAME")
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
