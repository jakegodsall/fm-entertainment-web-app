package com.jakegodsall.fmentertainmentwebappbackend.json;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.jakegodsall.fmentertainmentwebappbackend.entity.enums.Rating;

import java.io.IOException;

public class RatingDeserializer extends JsonDeserializer<Rating> {
    @Override
    public Rating deserialize(JsonParser jsonParser, DeserializationContext ctxt) throws IOException, JacksonException {
        String value = jsonParser.getText().toLowerCase();

        return switch (value) {
            case "pg" -> Rating.PG;
            case "e" -> Rating.E;
            case "18+" -> Rating.EIGHTEEN_PLUS;
            default -> throw new IOException("Invalid value for Category: " + value);
        };
    }
}
