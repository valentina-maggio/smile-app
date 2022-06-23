package com.example.smileapp.smile;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import static org.springframework.http.HttpStatus.NOT_FOUND;

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
    Smile smile = new Smile(false, true);
    BeanUtils.copyProperties(smileDto, smile);

    return smileRepository.save(smile);
  }

  @GetMapping("api/smiles/{id}")
  public Smile get(@PathVariable Long id) {
    return smileRepository.findById(id)
        .orElseThrow(() -> new ResponseStatusException(NOT_FOUND, "No smile exists with id " + id));
  }
}
