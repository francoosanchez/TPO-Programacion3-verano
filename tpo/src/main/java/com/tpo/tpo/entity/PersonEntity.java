package com.tpo.tpo.entity;


import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;

@Node("Person")
public class PersonEntity {

    @Id
    private String name;

    private String birthdate;
    private String birthplace;

    public PersonEntity() {
    }

    public PersonEntity(String name, String birthdate, String birthplace) {
        this.name = name;
        this.birthdate = birthdate;
        this.birthplace = birthplace;
    }

    // Getters y Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    public String getBirthplace() {
        return birthplace;
    }

    public void setBirthplace(String birthplace) {
        this.birthplace = birthplace;
    }
}