package com.mahesh.microservice1.controller;

import com.mahesh.microservice1.exception.DataNotFoundException;
import com.mahesh.microservice1.model.entity.MovieData;
import com.mahesh.microservice1.repository.MovieRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/api/movie")
public class MovieController {

    @Autowired
    private MovieRepo movieRepo;


    @GetMapping
    public List<MovieData> getAllMovieData(){
        return movieRepo.findAll();
    }

    @PostMapping
    public MovieData createMovie(@RequestBody MovieData movieData){
        return movieRepo.save(movieData);
    }

    @GetMapping("/{mid}")
    public ResponseEntity<MovieData> getMovie(@PathVariable int mid, @RequestBody MovieData moviedetails){
        MovieData movieData = movieRepo.findById(mid)
                .orElseThrow(() -> new DataNotFoundException("The movie not found with id:" + mid));

        return ResponseEntity.ok(movieData);
    }


    @PutMapping("/{mid}")
    public ResponseEntity<MovieData> updateMovie(@PathVariable int mid, @RequestBody MovieData moviedetails){
        MovieData updateMovie = movieRepo.findById(mid).get();

        updateMovie.setMid(moviedetails.getMid());
        updateMovie.setMname(moviedetails.getMname());
        updateMovie.setMtype(moviedetails.getMtype());
        updateMovie.setMrelease(moviedetails.getMrelease());

        movieRepo.save(updateMovie);

        return ResponseEntity.ok(updateMovie);
    }

    @DeleteMapping("{mid}")
    public ResponseEntity<HttpStatus> deleteMovie(@PathVariable int mid){
        MovieData movieData = movieRepo.findById(mid).get();

        movieRepo.delete(movieData);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/employee/{eid}")
    public ResponseEntity<Object> getEmployee(@PathVariable int eid) {
        String url = "http://192.168.118.89:8080/api/v1/employees/" + eid;

        ResponseEntity<Object> response = restTemplate.exchange(
                url,
                HttpMethod.GET,
                null,
                Object.class
        );

        return response;
    }

}
