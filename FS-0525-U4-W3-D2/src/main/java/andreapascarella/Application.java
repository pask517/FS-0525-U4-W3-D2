package andreapascarella;

import andreapascarella.dao.StudentsDAO;
import andreapascarella.entities.Student;
import andreapascarella.entities.StudentType;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Application {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("u4d12pu");

    public static void main(String[] args) {
        EntityManager entityManager = emf.createEntityManager();
        StudentsDAO sd = new StudentsDAO(entityManager);

        Student aldo = new Student("Aldo", "Baglio", StudentType.FULLSTACK);
        Student giovanni = new Student("Giovanni", "Storti", StudentType.FRONTEND);
        Student giacomo = new Student("Giacomo", "Poretti", StudentType.BACKEND);

        System.out.println(aldo);
        

        entityManager.close();
        emf.close();
        ;
    }
}
