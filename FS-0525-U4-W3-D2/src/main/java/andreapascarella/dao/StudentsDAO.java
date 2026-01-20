package andreapascarella.dao;

import andreapascarella.entities.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class StudentsDAO {
    private final EntityManager entityManager;

    public StudentsDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void save(Student newStudent) {
        EntityTransaction transaction = entityManager.getTransaction();

        transaction.begin();

        entityManager.persist(newStudent);

        transaction.commit();

        System.out.println("Lo studente " + newStudent.getSurname() + " é stato salvato correttiamente nel DB!");
    }
}
