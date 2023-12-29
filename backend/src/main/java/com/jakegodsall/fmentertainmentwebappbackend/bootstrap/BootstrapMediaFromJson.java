package com.jakegodsall.fmentertainmentwebappbackend.bootstrap;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jakegodsall.fmentertainmentwebappbackend.entity.Media;
import com.jakegodsall.fmentertainmentwebappbackend.json.MediaJsonMap;
import com.jakegodsall.fmentertainmentwebappbackend.repository.MediaRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.IOException;
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
        bootstrapFromJsonUsingCustomObject();
    }

    private void bootstrapFromJsonUsingCustomObject() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper()
                .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        String jsonInput = new String(Files.readAllBytes(Paths.get("./data.json")));

        List<MediaJsonMap> items = objectMapper.readValue(jsonInput, new TypeReference<List<MediaJsonMap>>() {});

        for (MediaJsonMap item : items) {
            mediaRepository.save(Media.builder()
                            .title(item.getTitle())
                            .category(item.getCategory())
                            .rating(item.getRating())
                            .isTrending(item.getIsTrending())
                            .year(item.getYear())
                            .imagePath(item.getThumbnail().getRegular().getMedium())
                            .build());
        }
    }
}
