package com.example.ahihi.entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name = "roles")
public class Roles {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @Column(name = "roleName", length = 50)
    String roleName;

    @Column(name = "description", length = 150, columnDefinition = "NVarchar(150)")
    String description;

    @ToString.Exclude
    @OneToMany(mappedBy = "roles", targetEntity = User.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonIgnore
    List<User> user;
}
