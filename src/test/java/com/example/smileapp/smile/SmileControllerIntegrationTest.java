package com.example.smileapp.smile;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.hamcrest.Matchers.hasSize;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureTestDatabase
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
public class SmileControllerIntegrationTest {
  @Autowired
  private MockMvc mvc;

  @Autowired
  private SmileRepository repository;

  @Test
  void WhenThereAreSmiles_SmilesReturnsListOfSmiles() throws Exception {
    repository.save(new Smile(false, true));
    repository.save(new Smile(true, false));
    mvc.perform(MockMvcRequestBuilders.get("/api/smiles").contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
        .andExpect(jsonPath("$", hasSize(2)));
  }

  @Test
  void SmilePostCreatesNewSmile() throws Exception {
    mvc.perform(
        MockMvcRequestBuilders.post("/api/smiles")
            .contentType(MediaType.APPLICATION_JSON)
            .content("{}"))
        .andExpect(status().isOk())
        .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON));

    Smile smile = repository.findFirstByOrderByIdAsc();
    assertEquals(false, smile.getCrying());
  }
}
