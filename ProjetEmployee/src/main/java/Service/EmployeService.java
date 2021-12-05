package Service;

import Entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.ArrayList;
import java.util.List;


public class EmployeService {
    List<Employee> employeeList = new ArrayList<>();

    protected void createEmploye() {
        // Création d'unemployé
        Employee employee = new Employee();
        employee.setNom("Tello");
        employee.setPreNom("Ludacriss");
        employee.setCourriel("tello@sncf.fr");
        employee.setAge(45);
        employee.setFonction("Dg");
        employee.setTelephone("06-58-78-95-65");
        employee.setAdressePostal(59658);
        employeeList.add(employee);
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(employee);
        session.getTransaction().commit();
        session.close();
    }

    // Affichage des employés
    protected Employee readAll(Employee employee){
        //Lecture d'un book
        Session session = sessionFactory.openSession();
      //  Employee employee = session.get(Employee.class, id);
        session.close();
        return employee;
    }

    // Affichage d'un 'employé
    protected Employee read(long id, Employee employee){
        //Lecture d'un employe
        Session session = sessionFactory.openSession();
       Employee employeeList = session.get(Employee.class, id );

        session.close();
        return employee;
    }

    // mise à jour d'un employé
    protected void update(long id, Employee newEmployee){
        // Mise à jour d'un employé
        Employee employee = this.read(id, newEmployee);
        if(newEmployee.getNom()!=null){
            employee.setNom((newEmployee.getNom()));
        }
        if(newEmployee.getPreNom()!=null){
            employee.setPreNom(newEmployee.getPreNom());
        }
        if(newEmployee.getAge() != 0){
            employee.setAge((newEmployee.getAge()));
        }
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.update(employee);
        session.getTransaction().commit();
        session.close();

    }

    protected void delete(Employee employee, long id){
        // suppression d'un employé
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.delete(employee);
        session.getTransaction().commit();
        session.close();
    }


    // on instancie la sessionFactory
    protected SessionFactory sessionFactory;

    // configuration  la  connexion et ouverture de session
    public void config() {

        final StandardServiceRegistry registry =
                new StandardServiceRegistryBuilder().configure().build();

        try {
            //on essaie de se connecter a la bdd
            //on construit notre sesison ici
            sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();

        } catch (Exception e) {
            StandardServiceRegistryBuilder.destroy(registry);
            e.getStackTrace();
        }

    }

    protected void exit() {
        sessionFactory.close();
    }

    public static void main(String[] args) {
        EmployeService embauche = new EmployeService();
        embauche.config();
        // Ajout d'un employé
       // embauche.createEmploye();
            // Affichage d'un employé
           // embauche.read(1);
        // Mise à jour d'un employé
        Employee employee = new Employee();
        employee = embauche.read(1, employee);
        employee.setNom("Jennifer");
        employee.setPreNom("Deff");
        embauche.update(1, employee);
            //suppression d'un employé
            //  embauche.delete( employee,6);
        embauche.exit();
    }

}



















