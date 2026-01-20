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

        System.out.println("Lo studente " + newStudent.getSurname() + " é stato salvato correttamente nel DB!");
    }

    public Student findById(long studentId) {
        Student found = entityManager.find(Student.class, studentId);
        if (found == null) throw new RuntimeException();
        return found;
    }

    public void findByIdAndDelete(long studentId) {
        Student found = this.findById(studentId);

        EntityTransaction transaction = entityManager.getTransaction();

        transaction.begin();

        entityManager.remove(found);

        transaction.commit();

        System.out.println("Lo studente con id:" + studentId + " é stato eliminato correttamente");
    }
}
