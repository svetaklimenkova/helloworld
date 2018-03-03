package by.slivki.trainings.dao.jpa;

import lombok.*;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Getter
@Setter
@Entity
@Table(name="users")
public class Role {
    @Column
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long roleId;
    @Column
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "role")
    private String roleName;


}
