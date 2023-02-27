package entity;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * Entity class extends Data class.
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table
public class Student extends DataEntity {

    @Column
    private String name;

    @Column
    private String surname;

    @ManyToMany(mappedBy = "students", cascade = CascadeType.ALL)
    private Set<Course> courseSet = new HashSet<>();

    @ManyToMany(mappedBy = "studentSet", cascade = CascadeType.ALL)
    private Set<Task> tasks = new HashSet<>();

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "student_review",
            joinColumns = {@JoinColumn(name = "student_id")},
            inverseJoinColumns = {@JoinColumn(name = "review_id")})
    private Set<Review> reviews = new HashSet<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Student student = (Student) o;
        return name.equals(student.name) && surname.equals(student.surname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), name, surname);
    }
}
