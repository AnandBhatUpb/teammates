package com.springboot.teammates.model;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private Long id;
    @Column
    private String firstName;
    @Column
    private String surname;
    @Column
    private String position;
    @Column
    private String githubProfile;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname= surname;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position= position;
    }

    public String getGithubProfile() {
        return githubProfile;
    }

    public void setGithubProfile(String githubProfile) {
        this.githubProfile = githubProfile;
    }


}