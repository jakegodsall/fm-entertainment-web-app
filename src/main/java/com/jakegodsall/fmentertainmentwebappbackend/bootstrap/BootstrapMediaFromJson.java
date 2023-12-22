package com.jakegodsall.fmentertainmentwebappbackend.bootstrap;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jakegodsall.fmentertainmentwebappbackend.entity.Media;
import com.jakegodsall.fmentertainmentwebappbackend.repository.MediaRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

@RequiredArgsConstructor
@Component
public class BootstrapMediaFromJson implements CommandLineRunner {

    private final MediaRepository mediaRepository;

    @Override
    @Transactional
    public void run(String... args) throws Exception {
        bootstrapFromJson();
    }

    private void bootstrapFromJson() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper()
                .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        String jsonInput = new String(Files.readAllBytes(Paths.get("./data.json")));

        List<Media> items = objectMapper.readValue(jsonInput,  new TypeReference<List<Media>>() {});

        mediaRepository.saveAll(items);
    }
}
