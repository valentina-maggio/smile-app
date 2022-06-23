package com.example.smileapp.smile;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SmileTest {
  @Test
  void testConstructs() {
    Smile subject = new Smile(false, true);
    assertEquals(false, subject.getCrying());
    assertEquals(true, subject.getLaughing());
  }

  @Test
  void testToString() {
    Smile subject = new Smile(false, true);
    assertEquals("Smile[id=null isCrying='false' isLaughing='true']",
        subject.toString());
  }
}
