package com.example.smileapp.smile;

import org.springframework.beans.BeanUtils;
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
  public Smile create(@RequestBody SmileDto smileDto) {
    Smile smile = new Smile();
    BeanUtils.copyProperties(smileDto, smile);

    return smileRepository.save(smile);
  }
}
