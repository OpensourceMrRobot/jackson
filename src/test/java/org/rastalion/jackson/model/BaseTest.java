package org.rastalion.jackson.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.util.UUID;

/*
Class that returns a valid BeerDto instance to our Test classes, good way to avoid duplicate @Before @After code...
 */

public class BaseTest {

    BeerDto getBeerDto() {
        return BeerDto.builder()
                .beerName("Augustijn")
                .beerStyle("Trappist bleek")
                .id(UUID.randomUUID())
                .createdDate(OffsetDateTime.now())
                .lastModifiedDate(OffsetDateTime.now())
                .price(new BigDecimal("3.99"))
                .upc(145789451265L)
                .myLocalDate(LocalDate.now())
                .build();
    }

}
