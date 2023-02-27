package entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * Data super class.
 */

@NoArgsConstructor
@Data
@MappedSuperclass
public class DataEntity {


@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column
    private Integer id;

}
