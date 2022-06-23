package com.example.smileapp.smile;

import javax.persistence.*;

@Entity
public class Smile {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  private Boolean isCrying;
  private Boolean isLaughing;

  public Smile() {
  }

  public Smile(Boolean isCrying, Boolean isLaughing) {
    this.isCrying = isCrying;
    this.isLaughing = isLaughing;
  }

  public void setCrying() {
    this.isCrying = true;
    this.isLaughing = false;
  }

  public void setLaughing() {
    this.isCrying = false;
    this.isLaughing = true;
  }

  public Boolean getCrying() {
    return this.isCrying;
  }

  public Boolean getLaughing() {
    return this.isLaughing;
  }

  public Long getId() {
    return id;
  }

  @Override
  public String toString() {
    return String.format("Smile[id=%d isCrying='%s' isLaughing='%s']", id, isCrying, isLaughing);
  }
}
