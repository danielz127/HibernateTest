import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.Date;


public class Main {
    public static void main(String[] args) {
        UserDetails userDetails = new UserDetails();
        userDetails.setUsername("thirdTimeeBuugy");
        Vehicle vehicle = new Vehicle();
        vehicle.setVehicleName("car");
        Vehicle vehicle1 = new Vehicle();
        vehicle1.setVehicleName("Jeep");
        vehicle.setUser(userDetails);
        vehicle1.setUser(userDetails);
        userDetails.getVehicle().add(vehicle);
        userDetails.getVehicle().add(vehicle1);

        SessionFactory sessionFactory= new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(userDetails);
        session.save(vehicle);
        session.save(vehicle1);
        session.getTransaction().commit();
        session.close();

        userDetails = null;
        session = sessionFactory.openSession();
        session.beginTransaction();
        userDetails = session.get(UserDetails.class, 1);
        System.out.println("User name: " + userDetails.getUsername());

    }
}
