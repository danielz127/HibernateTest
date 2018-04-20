import org.hibernate.annotations.CollectionId;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;


import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "USER_DETAILS")
public class UserDetails {


    private int userId;

    private Address homeAddress;


    private Address officeAddress;

    private String username;
    private Date dateTime;
    private Collection<Address> listOfAdresses = new ArrayList<Address>();
    private String description;

    @ElementCollection
    @GenericGenerator(name="sequence-gen", strategy="sequence")
    @CollectionId(columns = {@Column(name = "ADDRESS_ID")}, generator ="sequence-gen" , type =@Type(type = "long"))
    @JoinTable(name = "USER_ADDRESS",joinColumns = @JoinColumn(name = "USER_ID"))
    public Collection<Address> getListOfAdresses() {
        return listOfAdresses;
    }

    public void setListOfAdresses(Collection<Address> listOfAdresses) {
        this.listOfAdresses = listOfAdresses;
    }

    @Embedded
    public Address getOfficeAddress() {
        return officeAddress;
    }

    public void setOfficeAddress(Address officeAddress) {
        this.officeAddress = officeAddress;
    }

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "street", column = @Column(name = "HOME_STREET_NAME")),
            @AttributeOverride(name = "city", column = @Column(name = "HOME_CITY_NAME")),
            @AttributeOverride(name = "state", column = @Column(name = "HOME_STATE_NAME"))

    })
    public Address getHomeAddress() {
        return homeAddress;
    }

    public void setHomeAddress(Address address) {
        this.homeAddress = address;
    }

    @Temporal(TemporalType.DATE)
    public Date getDateTime() {
        return dateTime;
    }

    public void setDateTime(Date dateTime) {
        this.dateTime = dateTime;
    }

    @Lob
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
