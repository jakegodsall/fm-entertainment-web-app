package com.jakegodsall.fmentertainmentwebappbackend.mapper;

import com.jakegodsall.fmentertainmentwebappbackend.entity.Media;
import com.jakegodsall.fmentertainmentwebappbackend.payload.MediaDto;
import org.springframework.stereotype.Component;

@Component
public class MediaMapper {

    public static MediaDto mediaToMediaDto(Media media) {
        return MediaDto.builder()
                .id(media.getId())
                .title(media.getTitle())
                .category(media.getCategory())
                .rating(media.getRating())
                .isTrending(media.getIsTrending())
                .year(media.getYear())
                .build();
    }

    public static Media mediaDtoToMedia(MediaDto mediaDto) {
        return Media.builder()
                .id(mediaDto.getId())
                .title(mediaDto.getTitle())
                .category(mediaDto.getCategory())
                .rating(mediaDto.getRating())
                .isTrending(mediaDto.getIsTrending())
                .year(mediaDto.getYear())
                .build();
    }

}
