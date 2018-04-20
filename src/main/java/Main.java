import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.Date;


public class Main {
    public static void main(String[] args) {
        UserDetails userDetails = new UserDetails();
        userDetails.setUserId(1);
        userDetails.setUsername("thirdTimeeBuugy");
        userDetails.setDateTime(new Date());
        userDetails.setDescription("Description quite long");

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
