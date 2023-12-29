package com.jakegodsall.fmentertainmentwebappbackend.payload;

import com.jakegodsall.fmentertainmentwebappbackend.entity.enums.Category;
import com.jakegodsall.fmentertainmentwebappbackend.entity.enums.Rating;
import lombok.*;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class MediaDto {

    private Long id;

    private LocalDateTime createdDate;

    private LocalDateTime lastModifiedDate;

    private String title;

    private Category category;

    private Rating rating;

    private Boolean isTrending;

    private Integer year;

    private byte[] image;

}
