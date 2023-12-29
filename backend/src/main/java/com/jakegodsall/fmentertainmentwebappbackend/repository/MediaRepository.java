package com.jakegodsall.fmentertainmentwebappbackend.repository;

import com.jakegodsall.fmentertainmentwebappbackend.entity.Media;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MediaRepository extends JpaRepository<Media, Long> {
}
