package com.jakegodsall.fmentertainmentwebappbackend.service.impl;

import com.jakegodsall.fmentertainmentwebappbackend.entity.Media;
import com.jakegodsall.fmentertainmentwebappbackend.exceptions.ResourceNotFoundByIdException;
import com.jakegodsall.fmentertainmentwebappbackend.mapper.MediaMapper;
import com.jakegodsall.fmentertainmentwebappbackend.payload.MediaDto;
import com.jakegodsall.fmentertainmentwebappbackend.repository.MediaRepository;
import com.jakegodsall.fmentertainmentwebappbackend.service.MediaService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MediaServiceImpl implements MediaService {

    private final MediaRepository mediaRepository;

    @Override
    public List<MediaDto> getAllMedia() {
        return mediaRepository.findAll().stream()
                .map(MediaMapper::mediaToMediaDto)
                .toList();
    }

    @Override
    public MediaDto createMedia(MediaDto mediaDto) {
        // Create a media entity from DTO
        Media media = MediaMapper.mediaDtoToMedia(mediaDto);

        // Save the entity to the db
        Media savedMedia = mediaRepository.save(media);

        // Map the saved entity to DTO and return
        return MediaMapper.mediaToMediaDto(savedMedia);
    }

    @Override
    public MediaDto getMediaById(Long id) {
        // Get the media from the database
        Media media = mediaRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundByIdException("Media", id)
        );

        // Map the media to DTO and return
        return MediaMapper.mediaToMediaDto(media);
    }

    @Transactional
    @Override
    public MediaDto updateMediaById(MediaDto mediaDto, Long id) {
        // Get the media from the db
        Media mediaFromDb = mediaRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundByIdException("Media", id)
        );

        // Update last modified date to now
        mediaFromDb.setLastModifiedDate(LocalDateTime.now());

        // Update fields with values from DTO
        mediaFromDb.setTitle(mediaDto.getTitle());
        mediaFromDb.setCategory(mediaDto.getCategory());
        mediaFromDb.setRating(mediaDto.getRating());
        mediaFromDb.setIsTrending(mediaDto.getIsTrending());
        mediaFromDb.setYear(mediaDto.getYear());

        // Save updated object to db
        Media savedMedia = mediaRepository.save(mediaFromDb);

        // Map updated entity to DTO and return
        return MediaMapper.mediaToMediaDto(savedMedia);
    }

    @Transactional
    @Override
    public MediaDto patchUpdateMediaById(MediaDto mediaDto, Long id) {
        // Get the media from the db
        Media mediaFromDb = mediaRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundByIdException("Media", id)
        );

        // Update fields if field exists in DTO
        if (StringUtils.hasText(mediaDto.getTitle()))
            mediaFromDb.setTitle(mediaDto.getTitle());

        if (StringUtils.hasText(String.valueOf(mediaDto.getCategory())))
            mediaFromDb.setCategory(mediaDto.getCategory());

        if (StringUtils.hasText(String.valueOf(mediaDto.getRating())))
            mediaFromDb.setRating(mediaDto.getRating());

        if (StringUtils.hasText(String.valueOf(mediaDto.getIsTrending())))
            mediaFromDb.setIsTrending(mediaDto.getIsTrending());

        if (StringUtils.hasText(String.valueOf(mediaDto.getYear())))
            mediaFromDb.setYear(mediaDto.getYear());

        // Save the updated media to the database
        Media updatedMedia = mediaRepository.save(mediaFromDb);

        // Map updated entity to DTO and return
        return MediaMapper.mediaToMediaDto(updatedMedia);
    }

    @Override
    public void deleteMediaById(Long id) {
        // Get the entity from the database
        Media media = mediaRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundByIdException("Media", id)
        );

        // Delete the entity
        mediaRepository.delete(media);
    }

}
