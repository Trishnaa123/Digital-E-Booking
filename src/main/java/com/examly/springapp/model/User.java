package com.examly.springapp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class User {
  @Id
  private long userId;
  private String name;
  private String email;
  private String subscriptionType;
  public User(){

  }
  public long getId(){
    return userId;
  }

  public void setId(long userId){
    this.userId=userId;
  }
  public String getname(){
    return name;
  }
  public void setname(String name){
    this.name=name;
  }
  public String getEmail(){
    return email;
  }
  public void setEmail(String email){
    this.email=email;
  }
  public String getSubscriptionType(){
    return subscriptionType;
  }
  public void setSubscriptionType(String subscriptionType){
    this.subscriptionType=subscriptionType;
  }
}

