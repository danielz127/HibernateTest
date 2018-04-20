import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.Date;


public class Main {
    public static void main(String[] args) {
        UserDetails userDetails = new UserDetails();
        userDetails.setUsername("thirdTimeeBuugy");
        userDetails.setDateTime(new Date());
        userDetails.setDescription("Description quite long");
        Address address = new Address();
        address.setCity("Warszawa");
        address.setState("Mazowia");
        address.setStreet("Main");
        userDetails.setHomeAddress(address);

        Address address2 = new Address();
        address2.setCity("Krakow");
        address2.setState("Malopolskie");
        address2.setStreet("Wawelska");
        userDetails.setOfficeAddress(address2);
        userDetails.getListOfAdresses().add(address);
        userDetails.getListOfAdresses().add(address2);

        SessionFactory sessionFactory= new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(userDetails);
        session.getTransaction().commit();
        session.close();

        userDetails = null;
        session = sessionFactory.openSession();
        session.beginTransaction();
        userDetails = session.get(UserDetails.class, 1);
        System.out.println("User name: " + userDetails.getUsername());

    }
}
