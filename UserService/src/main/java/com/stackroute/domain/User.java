package com.stackroute.domain;

import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.ArrayList;
import java.util.List;

@Document
public class User {

    @Id
    int id;
    String firstName;
    String lastName;
    int age;
    Track favouriteList[]= new Track[30];


    public User(){

    }
    public User(String firstName, String lastName, int age, String userName,int id, Track[] favouriteList) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.userName = userName;
        this.id = id;
        this.favouriteList=favouriteList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Track[] getFavouriteList(){
        return favouriteList;
    }

    public void addTrackToFavouriteList(Track track,int i){
        this.favouriteList[i]=track;
    }

    String userName;


    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", userName='" + userName + '\'' +
                '}';
    }
}
