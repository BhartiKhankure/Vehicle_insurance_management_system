package com.edu.VehicleManagementAppSpringBoot.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.edu.VehicleManagementAppSpringBoot.entity.Search;
import com.edu.VehicleManagementAppSpringBoot.exception.ResourceNotFound;
import com.edu.VehicleManagementAppSpringBoot.repository.SearchRepository;
import com.edu.VehicleManagementAppSpringBoot.service.SearchService;

@Service
public class SearchServiceImpl implements SearchService {

	private SearchRepository searchRepository;

	public SearchServiceImpl(SearchRepository searchRepository) {
		super();
		this.searchRepository = searchRepository;
	}

	@Override
	public Search saveSearch(Search search) {
		return searchRepository.save(search);
	}

	@Override
	public List<Search> insertAll(List<Search> search) {
		return (List<Search>) searchRepository.saveAll(search);

	}

	@Override
	public List<Search> getAllSearch() {
		return searchRepository.findAll();
	}

	@Override
	public Search getSearchById(long id) {
		Optional<Search> search = searchRepository.findById(id);
		if (search.isPresent()) {
			return search.get();
		} else {
			throw new ResourceNotFound("Search", "id", id);
		}
	}

	@Override
	public Search updateSearch(Search search, long id) {
		Search sea = new Search();
		try {
			sea = searchRepository.findById(id).orElseThrow(() -> new ResourceNotFound("Search", "id", id));
		} catch (ResourceNotFound e) {
			e.printStackTrace();
		}

		sea.setUsername(search.getUsername());
		sea.setLicenceNumber(search.getLicenceNumber());
		sea.setPlateNumber(search.getPlateNumber());
		sea.setInsuranceNumber(search.getInsuranceNumber());

		searchRepository.save(sea);
		return sea;
	}

	@Override
	public void deleteSearch(long id) {
		searchRepository.findById(id).orElseThrow(() -> new ResourceNotFound("Search", "id", id));
		searchRepository.deleteById(id);

	}

	@Override
	public Search updateSearchPartially(Search search, long id) {
		Search sea = new Search();
		try {
			sea = searchRepository.findById(id).orElseThrow(() -> new ResourceNotFound("Search", "Id", id));
		} catch (ResourceNotFound e) {
			e.printStackTrace();
		}

		if (search.getUsername() != null) {
			sea.setUsername(search.getUsername());
		}
		if (search.getLicenceNumber() != null) {
			sea.setLicenceNumber(search.getLicenceNumber());
			;
		}
		if (search.getPlateNumber() != null) {
			sea.setPlateNumber(search.getPlateNumber());
		}
		if (search.getInsuranceNumber() != null) {
			sea.setInsuranceNumber(search.getInsuranceNumber());
		}
		searchRepository.save(sea);
		return sea;
	}
}
