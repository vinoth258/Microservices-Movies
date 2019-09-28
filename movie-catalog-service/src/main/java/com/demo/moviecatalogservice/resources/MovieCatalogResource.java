package com.demo.moviecatalogservice.resources;

import java.util.Collections;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.moviecatalogservice.model.MovieCatalog;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogResource {

	@RequestMapping("/{userId}")
	public List<MovieCatalog> getMovieCatalog(@PathVariable("userId") String userId) {
		return Collections.singletonList(new MovieCatalog("KGF", "Good", 4));
	}
}
