package entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "task_id")
    private Integer id;

    @Column
    private String description;


    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer courseId;

    @ManyToMany(mappedBy = "tasks")
    private Set<Student> students = new HashSet<>();

}

