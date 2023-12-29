package com.jakegodsall.fmentertainmentwebappbackend.json;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.jakegodsall.fmentertainmentwebappbackend.entity.enums.Category;
import com.jakegodsall.fmentertainmentwebappbackend.entity.enums.Rating;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class MediaJsonMap {
    private String title;

    private Integer year;

    @JsonDeserialize(using = CategoryDeserializer.class)
    private Category category;

    @JsonDeserialize(using = RatingDeserializer.class)
    private Rating rating;

    private Boolean isTrending;

    private Thumbnail thumbnail;

    @Getter
    @Setter
    public static class Thumbnail {
        private Size regular;

        @Getter
        @Setter
        public static class Size {
            private String small;
            private String medium;
            private String large;

            @Override
            public String toString() {
                return "Size{" +
                        "small='" + small + '\'' +
                        ", medium='" + medium + '\'' +
                        ", large='" + large + '\'' +
                        '}';
            }
        }

        @Override
        public String toString() {
            return "Thumbnail{" +
                    "regular=" + regular +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "MediaJsonMap{" +
                "title='" + title + '\'' +
                ", year=" + year +
                ", category=" + category +
                ", rating=" + rating +
                ", isTrending=" + isTrending +
                ", thumbnail=" + thumbnail +
                '}';
    }
}
