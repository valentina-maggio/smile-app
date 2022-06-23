package com.example.smileapp.smile;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class SmileController {
  @Autowired
  private SmileRepository smileRepository;

  @GetMapping("/api/smiles")
  public Iterable<Smile> smile() {
    return smileRepository.findAll();
  }

  @PostMapping("/api/smiles")
  public Smile create(@RequestBody Smile smile) {

    return smileRepository.save(smile);
  }
}
