package entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "student_id")
    private Integer id;
    @Column
    private String name;
    @Column
    private String surname;


    //не знаю нужна ли нам джоин табличка курсов и студентов
    //поэтому просто закоментил
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    /*@JoinTable(name = "student_course",
            joinColumns = {@JoinColumn(name = "student_id")},
            inverseJoinColumns = {@JoinColumn(name = "course_id")})*/
    private Set<Course> courses = new HashSet<>();

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    /*@JoinTable(name = "student_task",
            joinColumns = {@JoinColumn(name = "student_id")},
            inverseJoinColumns = {@JoinColumn(name = "task_id")})*/
    private Set<Task> tasks = new HashSet<>();


    @OneToOne(fetch = FetchType.LAZY, mappedBy = "student",
            cascade = CascadeType.ALL)
    private Review review;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(id, student.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
