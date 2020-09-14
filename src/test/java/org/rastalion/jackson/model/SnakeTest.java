package org.rastalion.jackson.model;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.test.context.ActiveProfiles;

@ActiveProfiles("snake")  // Based on our resources/application-snake.properties, Spring Boot recognizes it as a Profile
@JsonTest
public class SnakeTest extends BaseTest {

    @Autowired
    ObjectMapper objectMapper;

    /*
    We are writing a test to see our properties using the snake format notation
     */
    @Test
    void testSnakeCasing() throws JsonProcessingException {
        BeerDto dto = getBeerDto();

        String jsonSnakeNotation = objectMapper.writeValueAsString(dto);
        System.out.println(jsonSnakeNotation);
    }

}
