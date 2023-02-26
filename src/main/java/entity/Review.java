package entity;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
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
public class Review extends DataEntity {

    @Column
    private Integer mark;

    @Column
    private String review;

    @ManyToMany(mappedBy = "reviewSet")
    private Set<Task> tasks = new HashSet<>();

    @ManyToMany(mappedBy = "reviews", cascade = CascadeType.ALL)
    private Set<Student> studentHashSet = new HashSet<>();

}
