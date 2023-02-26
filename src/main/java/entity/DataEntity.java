package entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
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
@GeneratedValue(strategy = GenerationType.AUTO)
@Column
    private Integer id;

}
