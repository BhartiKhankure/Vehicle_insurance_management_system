package com.edu.VehicleManagementAppSpringBoot.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.edu.VehicleManagementAppSpringBoot.entity.Insurance;
import com.edu.VehicleManagementAppSpringBoot.exception.ResourceNotFound;
import com.edu.VehicleManagementAppSpringBoot.repository.InsuranceRepository;
import com.edu.VehicleManagementAppSpringBoot.service.InsuranceService;

@Service
public class InsuranceServiceImpl implements InsuranceService {

	private InsuranceRepository insuranceRepository;

	public InsuranceServiceImpl(InsuranceRepository insuranceRepository) {
		super();
		this.insuranceRepository = insuranceRepository;
	}

	@Override
	public Insurance saveInsurance(Insurance insurance) {
		return insuranceRepository.save(insurance);
	}

	@Override
	public List<Insurance> getAllInsurance() {
		return insuranceRepository.findAll();
	}

	@Override
	public Insurance getInsuranceById(long id) {
		Optional<Insurance> insurance = insuranceRepository.findById(id);
		if (insurance.isPresent()) {
			return insurance.get();
		} else {
			throw new ResourceNotFound("Insurance", "id", id);
		}

	}

	@Override
	public Insurance updateInsurance(Insurance insurance, long id) {
		Insurance ins = new Insurance();
		try {
			ins = insuranceRepository.findById(id).orElseThrow(() -> new ResourceNotFound("Insurance", "id", id));
		} catch (ResourceNotFound e) {
			e.printStackTrace();
		}

		ins.setInsuranceProvider(insurance.getInsuranceProvider());
		ins.setInsuranceNumber(insurance.getInsuranceNumber());
		ins.setInsuranceValidity(insurance.getInsuranceValidity());

		insuranceRepository.save(ins);
		return ins;
	}

	@Override
	public void deleteInsurance(long id) {
		insuranceRepository.findById(id).orElseThrow(() -> new ResourceNotFound("Insurance", "id", id));
		insuranceRepository.deleteById(id);

	}

	@Override
	public List<Insurance> insertAll(List<Insurance> insurance) {
		return (List<Insurance>) insuranceRepository.saveAll(insurance);

	}

	@Override
	public Insurance updateInsurancePartially(Insurance insurance, long id) {
		Insurance ins = new Insurance();
		try {
			ins = insuranceRepository.findById(id).orElseThrow(() -> new ResourceNotFound("Insurance", "Id", id));
		} catch (ResourceNotFound e) {
			e.printStackTrace();
		}

		if (insurance.getInsuranceProvider() != null) {
			ins.setInsuranceProvider(insurance.getInsuranceProvider());
		}
		if (insurance.getInsuranceNumber() != null) {
			ins.setInsuranceNumber(insurance.getInsuranceNumber());
		}
		if (insurance.getInsuranceValidity() != null) {
			ins.setInsuranceValidity(insurance.getInsuranceValidity());
		}
		insuranceRepository.save(ins);
		return ins;
	}

	@Override
	public List<Insurance> getInsuranceByInsuranceProvider(String insuranceProvider) {
		return insuranceRepository.findByinsuranceProvider(insuranceProvider);
	}

	@Override
	public Optional<Insurance> getInsuranceByInsuranceNumber(String insuranceNumber) {
		return insuranceRepository.findByInsuranceNumber(insuranceNumber);
	}
}
