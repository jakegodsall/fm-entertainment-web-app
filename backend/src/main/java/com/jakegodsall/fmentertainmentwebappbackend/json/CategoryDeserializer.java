package com.jakegodsall.fmentertainmentwebappbackend.json;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.jakegodsall.fmentertainmentwebappbackend.entity.enums.Category;

import java.io.IOException;

public class CategoryDeserializer extends JsonDeserializer<Category> {
    @Override
    public Category deserialize(JsonParser jsonParser, DeserializationContext ctxt) throws IOException, JacksonException {
        String value = jsonParser.getText().toLowerCase();

        return switch (value) {
            case "movie" -> Category.MOVIE;
            case "tv series" -> Category.TV_SERIES;
            default -> throw new IOException("Invalid value for Category: " + value);
        };
    }
}
