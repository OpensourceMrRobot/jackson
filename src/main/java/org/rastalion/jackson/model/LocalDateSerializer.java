package org.rastalion.jackson.model;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/*
Here we are creating a date serializer class that extends the superclass JsonSerializer
Make sure to specify the data type you want to use [i.e.g, LocalDate]
 */

public class LocalDateSerializer extends JsonSerializer<LocalDate> {

    @Override
    public void serialize(LocalDate value, JsonGenerator jsonGenerator, SerializerProvider serializerProvider)
            throws IOException {

        /*
        You could do whatever here programmatically to get a proper formatting for your objects to JSON
        [thus also other things then date conversions]

        ...

        Here we do a basic formatting, nothing big...
            ->  [Right-click BASIC_ISO_DATE if you want to see more choices]

         */
        jsonGenerator.writeObject(value.format(DateTimeFormatter.BASIC_ISO_DATE));
    }
}
