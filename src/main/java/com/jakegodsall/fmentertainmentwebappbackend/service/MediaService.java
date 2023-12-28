package com.jakegodsall.fmentertainmentwebappbackend.service;

import com.jakegodsall.fmentertainmentwebappbackend.payload.MediaDto;

import java.util.List;

public interface MediaService {

    List<MediaDto> getAllMedia();

    MediaDto createMedia(MediaDto mediaDto);

    MediaDto getMediaById(Long id);

    MediaDto updateMediaById(MediaDto mediaDto, Long id);

    MediaDto patchUpdateMediaById(MediaDto mediaDto, Long id);

    void deleteMediaById(Long id);

}
