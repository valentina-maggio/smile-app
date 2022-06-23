package com.example.smileapp.smile;

public class SmileDto {
  private Long id;
  private Boolean isCrying = false;
  private Boolean isLaughing = true;

  public SmileDto() {
  }

  public SmileDto(Boolean isCrying, Boolean isLaughing) {
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
}
