package com.edu.VehicleManagementAppSpringBoot.service;

import java.util.List;

import com.edu.VehicleManagementAppSpringBoot.entity.Search;

public interface SearchService {

	Search saveSearch(Search search);

	List<Search> insertAll(List<Search> search);

	List<Search> getAllSearch();

	Search getSearchById(long id);

	Search updateSearch(Search search, long id);

	void deleteSearch(long id);

	Search updateSearchPartially(Search search, long id);

}
