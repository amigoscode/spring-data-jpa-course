package com.example.demo.pojos;

public class StudentRequest {
    private String firstName;
    private String lastName;
    private String email;
    private String field;
    private Integer age;
    private Long countryId;

    public StudentRequest(String firstName, String lastName, String email, String field, Integer age, Long countryId) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.field = field;
        this.age = age;
        this.countryId = countryId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Long getCountryId() {
        return countryId;
    }

    public void setCountryId(Long countryId) {
        this.countryId = countryId;
    }
}
