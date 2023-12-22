package com.jakegodsall.fmentertainmentwebappbackend.payload;

import com.jakegodsall.fmentertainmentwebappbackend.entity.enums.Category;
import com.jakegodsall.fmentertainmentwebappbackend.entity.enums.Rating;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class MediaDto {

    private Long id;

    private LocalDateTime createdDate;

    private LocalDateTime lastModifiedDate;

    private Category category;

    private Rating rating;

    private Boolean isTrending;

    private Integer year;

    private byte[] image;

}
