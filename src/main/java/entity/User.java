package entity;

import lombok.*;

import javax.persistence.*;

/**
 * Entity class extends Data class.
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table
public class User extends DataEntity {

    @Column
    private String login;

    @Column
    private String password;

}
