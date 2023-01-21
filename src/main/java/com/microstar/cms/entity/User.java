package com.microstar.cms.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.List;

@Entity
@Data
@Getter
@Setter
@NoArgsConstructor
@Table(name="USER_TBL")
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @JsonProperty("email")
    @Column(unique = true)
    private String email;
    @JsonProperty("password")
    @Column(length=16)
    private String password;
    @JsonProperty("fullName")
    @Column(length=60, name="name")
    private String fullName;
    @JsonProperty("address")
    @Column(length=100)
    private String address;
    @JsonProperty("contact")
    @Column(length=13, name="contact")
    private String phoneNo;
    @JsonProperty("role")
    @OneToOne(mappedBy = "id")
    private Role role;
    @OneToMany(mappedBy = "caseNo")
    private List<Complaint> complaintsList;

    public User(Long id, String email, String password, String fullName, String address, String phoneNo, Role role, List<Complaint> complaintsList) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.fullName = fullName;
        this.address = address;
        this.phoneNo = phoneNo;
        this.role = role;
        this.complaintsList = complaintsList;
    }


}
