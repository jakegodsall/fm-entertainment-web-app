package com.jakegodsall.fmentertainmentwebappbackend.entity;

import com.jakegodsall.fmentertainmentwebappbackend.entity.enums.Category;
import com.jakegodsall.fmentertainmentwebappbackend.entity.enums.Rating;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.Year;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@SuperBuilder
@Entity
@Table(
        name = "media"
)
public class Media extends BaseEntity {

    @Size(max = 200, message = "Title must not exceed 200 characters")
    @NotNull
    @Column(length = 200, nullable = false)
    private String title;

    @Enumerated(EnumType.STRING)
    private Category category;

    @Enumerated(EnumType.STRING)
    private Rating rating;

    @Builder.Default
    private Boolean isTrending = false;

    @NotNull
    @Column(nullable = false)
    private Integer year;

    @Lob
    @Column(name = "image", columnDefinition = "LONGBLOB")
    private byte[] image;

}
