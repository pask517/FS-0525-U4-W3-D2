package andreapascarella;

import andreapascarella.dao.StudentsDAO;
import andreapascarella.entities.Student;
import andreapascarella.entities.StudentType;
import andreapascarella.exceptions.NotFoundException;
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

        //sd.save(aldo);
        //sd.save(giovanni)
        //sd.save(giacomo)
        try {
            Student studentFromDB = sd.findById(1);
            System.out.println(studentFromDB);
        } catch (NotFoundException ex) {
            System.out.println(ex.getMessage());
        }

        sd.findByIdAndDelete(2);


        entityManager.close();
        emf.close();
        ;
    }
}
