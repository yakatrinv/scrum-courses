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
public class Teacher extends DataEntity {

    @Column
    private String name;

    @Column
    private String surname;

    @OneToMany(mappedBy = "teacher", cascade = CascadeType.ALL)
    private Set<Course> courses = new HashSet<>();

}
