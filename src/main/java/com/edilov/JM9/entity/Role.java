package com.edilov.JM9.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import javax.persistence.*;
import java.util.Objects;
import java.util.Set;


@NoArgsConstructor
@AllArgsConstructor @Data
@Entity
public class Role implements GrantedAuthority {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private long id;
   private String role;

   @ManyToMany(mappedBy = "roles")
   private Set<User> users;


   public Role(long id) {
       this.id = id;
   }

   public Role(String role) {
       this.role = role;
   }

   @Override
   public String getAuthority() {
            return role;
        }

   @Override
   public String toString() {
        return "Role{" +
                "id=" + id +
                ", role='" + role + '\'' +
                ", users=" + users +
                '}';
   }

   @Override
   public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Role role1 = (Role) o;
            return id == role1.id && Objects.equals(role, role1.role) && Objects.equals(users, role1.users);
   }

    @Override
    public int hashCode() {
        return Objects.hash(id, role);
    }
}
