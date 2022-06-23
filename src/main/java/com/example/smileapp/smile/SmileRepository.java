package com.example.smileapp.smile;

import org.springframework.data.repository.CrudRepository;

public interface SmileRepository extends CrudRepository<Smile, Long> {
  Smile findFirstByOrderByIdAsc();
}
