package com.sdm.Project.domain;

import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class Person {

    private String name;
    private String gender;
    private int age;
    private String address;

    public Person(String name, String gender, int age, Address address) {
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.address = address.toString();
    }

    public Person() {

    }

    public static class Address {
        private String sector;
        private String street;

        public Address(String sector, String street) {
            this.sector = sector;
            this.street = street;
        }

        public String getSector() {
            return sector;
        }

        public void setSector(String sector) {
            this.sector = sector;
        }

        public String getStreet() {
            return street;
        }

        public void setStreet(String street) {
            this.street = street;
        }

        @Override
        public String toString() {
            return sector + " " + street;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                '}';
    }
}
