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
public class Course extends DataEntity{

    @Column
    private String description;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "teacher_id", nullable = false)
    private Teacher teacher;


    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "course_student",
            joinColumns = {@JoinColumn(name = "course_id")},
            inverseJoinColumns = {@JoinColumn(name = "student_id")})
    private Set<Student> students = new HashSet<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Course course = (Course) o;
        return Objects.equals(getId(), course.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
