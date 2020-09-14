package org.rastalion.jackson.model;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;

@JsonTest
class BeerDtoTest extends BaseTest {

    @Autowired
    ObjectMapper objectMapper;

    @Test
    void serializationBeerDto() throws JsonProcessingException {
        /*
        This is not a real unit test, this is mostly done to show you the different ways of serializing your objects.
         */
        BeerDto dto = getBeerDto();

        String jsonString = objectMapper.writeValueAsString(dto);
        System.out.println(jsonString);
    }

    @Test
    void deserializationBeerDto() throws JsonProcessingException {
        /*
        Take a look at myLocalDate in our string and the one printed out on line 37
         */
        String json = "{\"beerName\":\"Augustijn\",\"beerStyle\":\"Trappist bleek\",\"upc\":145789451265," +
                "\"price\":\"3.99\",\"createdDate\":\"2019-12-27T18:11:38+0100\",\"lastModifiedDate\":" +
                "\"2019-12-27T18:11:38.7486116+01:00\",\"myLocalDate\":\"20191227\"," +
                "\"beerId\":\"12161f3e-fe2b-40ef-81a2-9a7080e6aa65\"}\n";

        BeerDto dto = objectMapper.readValue(json, BeerDto.class);
        System.out.println(dto);
    }

}