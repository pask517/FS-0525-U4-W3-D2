package andreapascarella.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "first_name", nullable = false)
    private String name;

    @Column(name = "last_name", nullable = false)
    private String surname;

    @Column(name = "type", nullable = false)
    @Enumerated(EnumType.STRING)
    private StudentType studentType;

    public Student() {
    }

    public Student(String name, String surname, StudentType type) {
        this.name = name;
        this.surname = surname;
        this.studentType = type;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", studentType=" + studentType +
                '}';
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public StudentType getStudentType() {
        return studentType;
    }

    public void setStudentType(StudentType studentType) {
        this.studentType = studentType;
    }
}
