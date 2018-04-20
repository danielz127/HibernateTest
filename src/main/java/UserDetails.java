import javax.persistence.*;
import java.util.Date;

@Entity(name = "USER_DETAILS")
public class UserDetails {

    private int userId;

    private String username;
    private Date dateTime;

    private String description;

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
    @Column(name = "USER_ID")
    public int getUserId() {
        return userId;
    }


    public void setUserId(int userId) {
        this.userId = userId;
    }


    @Column(name = "USER_NAME")
    public String getUsername() {
        return username + " from getter";
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
