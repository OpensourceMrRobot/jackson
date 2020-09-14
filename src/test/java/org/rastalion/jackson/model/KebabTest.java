package org.rastalion.jackson.model;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.test.context.ActiveProfiles;

/*
This will write our dto to a kebab formatted JSON object,
we also have one configured for the snake notation, see SnakeTest.java for that one.
 */

@ActiveProfiles("kebab")
@JsonTest
public class KebabTest extends BaseTest{

    @Autowired
    ObjectMapper objectMapper;

    @Test
    void testKebabCasing() throws JsonProcessingException {
        BeerDto dto = getBeerDto();

        String jsonKebabNotation = objectMapper.writeValueAsString(dto);
        System.out.println(jsonKebabNotation);
    }

}
