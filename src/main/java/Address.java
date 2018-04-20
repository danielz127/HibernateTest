import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Address {

    private String city;

    private  String street;

    private String state;

    @Column(name = "CITY_NAME")
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
    @Column(name = "STREET_NAME")
    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }
    @Column(name = "STATE_NAME")
    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
