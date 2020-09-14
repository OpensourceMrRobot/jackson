package org.rastalion.jackson.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BeerDto {

    /*
    This use of the below annotation is so that we can declare the id as beerId
     */
    @JsonProperty("beerId")
    @Null
    private UUID id;

    @NotBlank
    private String beerName;

    @NotBlank
    private String beerStyle;

    @Positive
    private Long upc;

    /*
    This will make sure that our price will be handled as a String,
    which is a good idea, because the world economy is a mess.
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private BigDecimal price;

    /*
    Needs this pattern otherwise the deserializationBeerDto test will fail, duh.
     */
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ssZ", shape = JsonFormat.Shape.STRING)
    private OffsetDateTime createdDate;

    private OffsetDateTime lastModifiedDate;

    /*
    This will tell jackson how to serialize our LocalDate values

    yyyy-mm-dd becomes: yyyymmdd

    We are using our own LocalDateSerializer.class to do this parsing...
    We can do this because we extend: JsonSerializer<LocalDate> in that class.

    This is actually a second way to convert date time objects;
    We seem to have a lot of them and that's why we use this technique most often with dates.
     */
    @JsonSerialize(using = LocalDateSerializer.class)
    @JsonDeserialize(using = LocalDateDeserializer.class)
    private LocalDate myLocalDate;
}
