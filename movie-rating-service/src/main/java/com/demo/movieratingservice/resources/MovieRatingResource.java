package com.demo.movieratingservice.resources;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.movieratingservice.model.Rating;

@RestController
@RequestMapping("/rating")
public class MovieRatingResource {

	@RequestMapping("/{movieId}")
	public List<Rating> getMovieRatings(@PathVariable("movieId") String movieId) {
		
		return Arrays.asList(new Rating("101", 3),
							 new Rating("102", 4));
	}
}
