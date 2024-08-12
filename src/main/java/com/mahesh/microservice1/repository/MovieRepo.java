package com.mahesh.microservice1.repository;

import com.mahesh.microservice1.model.entity.MovieData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepo extends JpaRepository<MovieData, Integer> {
}
