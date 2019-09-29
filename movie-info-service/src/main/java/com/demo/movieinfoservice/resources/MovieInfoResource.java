package com.demo.movieinfoservice.resources;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.movieinfoservice.model.Movie;

@RestController
@RequestMapping("/movieInfo")
public class MovieInfoResource {

	@RequestMapping("/{movieId}")
	public Movie movieInfo(@PathVariable("movieId") String movieId) {
		return new Movie(movieId, "Test");
	}
}
