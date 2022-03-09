package com.edu.VehicleManagementAppSpringBoot.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edu.VehicleManagementAppSpringBoot.entity.Search;
import com.edu.VehicleManagementAppSpringBoot.service.SearchService;

@RestController
@RequestMapping("/api/search")
public class SearchController {
	private static final String REQUEST_NO_BODY = "Request does not contain a body";

	private SearchService searchService;

	public SearchController(SearchService searchService) {
		super();
		this.searchService = searchService;
	}

	@PostMapping
	public ResponseEntity<Search> saveSearch(@RequestBody Search search) {
		return new ResponseEntity<Search>(searchService.saveSearch(search), HttpStatus.CREATED);
	}

	@PostMapping("/bulkSearch")
	public String addSearch(@RequestBody List<Search> search) {
		if (search != null && !search.isEmpty()) {
			searchService.insertAll(search);
			return String.format("Added search.", search.size());
		} else {
			return REQUEST_NO_BODY;
		}
	}

	@GetMapping
	public List<Search> getAllSearch() {
		return searchService.getAllSearch();
	}

	@GetMapping("{id}")
	public ResponseEntity<Search> getSearchById(@PathVariable("id") long id) {
		return new ResponseEntity<Search>(searchService.getSearchById(id), HttpStatus.OK);

	}

	@PutMapping("{id}")
	public ResponseEntity<Search> updateSearch(@PathVariable("id") long id, @RequestBody Search search) {
		return new ResponseEntity<Search>(searchService.updateSearch(search, id), HttpStatus.OK);

	}

	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteSearch(@PathVariable("id") long id) {
		searchService.deleteSearch(id);
		return new ResponseEntity<String>("Search record deleted", HttpStatus.OK);

	}

	@PatchMapping("{id}")
	public ResponseEntity<Search> updateSearchPartially(@PathVariable("id") long id, @RequestBody Search search) {
		return new ResponseEntity<Search>(searchService.updateSearchPartially(search, id), HttpStatus.OK);

	}
}
