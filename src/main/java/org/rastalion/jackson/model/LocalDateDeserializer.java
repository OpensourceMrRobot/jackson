package org.rastalion.jackson.model;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/*
Of course we will also need a way to deserialize and we can do this as seen in this class xD
 */

public class LocalDateDeserializer extends StdDeserializer<LocalDate> {

    /*
    This needs to be done our your compiler wont be happy!
     */
    protected LocalDateDeserializer() {
        super(LocalDate.class);
    }

    @Override
    public LocalDate deserialize(JsonParser jsonParser, DeserializationContext deserializationContext)
            throws IOException, JsonProcessingException {

        /*
        And this is how you deserialize the whole thing :D,
        dont forget to use the @JsonDeserialize annotation in the BeerDto class [as seen on line 69 over there]
         */
        return LocalDate.parse(jsonParser.readValueAs(String.class), DateTimeFormatter.BASIC_ISO_DATE);
    }
}
