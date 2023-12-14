package com.example.warehouseprofi.models.entities;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "roles")
public class Role extends BaseEntity {
    private Set<User> users;
    private com.example.warehouseprofi.models.enums.Role name;

    public Role(){
        users = new HashSet<>();
    }

    @OneToMany(mappedBy = "role", targetEntity = User.class, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    @Column(nullable = false, unique = true)
    @Enumerated(EnumType.STRING)
    public com.example.warehouseprofi.models.enums.Role getName() {
        return name;
    }

    public void setName(com.example.warehouseprofi.models.enums.Role name) {
        this.name = name;
    }
}
