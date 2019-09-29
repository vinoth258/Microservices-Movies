package com.demo.moviecatalogservice.resources;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.demo.moviecatalogservice.model.Movie;
import com.demo.moviecatalogservice.model.MovieCatalog;
import com.demo.moviecatalogservice.model.Rating;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogResource {
	
	@Autowired
	RestTemplate restTemplate;

	@RequestMapping("/{userId}")
	public List<MovieCatalog> getMovieCatalog(@PathVariable("userId") String userId) {
		
		//Get all movie Ratings
		List<Rating> ratings = Arrays.asList(new Rating("101", 3),
											 new Rating("102", 4),
											 new Rating("103", 3));
		
		
		//Get movie Info
		//Put all together
		return ratings.stream().map(rating -> {
			
			Movie movie = restTemplate.getForObject("http://localhost:8082/movieInfo/"+rating.getMovieId(), Movie.class);
			
			return new MovieCatalog(movie.getName(),"Desc",rating.getRating());
		}).collect(Collectors.toList());
		
		
	}
}
