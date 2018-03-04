package by.slivki.trainings.dao.jpa;

import lombok.*;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name="roles")
public class Role {
    @Column
    @Id
    private int roleId;
    @Column
    private String roleName;

    public Role(RoleEnum roleEnum) {
        this.roleId = roleEnum.getI();
        this.roleName = roleEnum.name();
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
}
