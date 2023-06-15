package com.myCompany.MyWebApp.user;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private  Integer id;
    @Column(nullable = false, unique = true,name = "email")
    @Email
    private String email;

    @Column(nullable = false,length = 30,name = "password")
    private String password;

    @Column(nullable = false,length = 50,name = "first_name")
    private String firstName;


    @Column(nullable = false,length = 100,name = "last_name")
    private String lastName;
    @Column(nullable = false)
    @NotNull
    private Boolean enabled;


}
