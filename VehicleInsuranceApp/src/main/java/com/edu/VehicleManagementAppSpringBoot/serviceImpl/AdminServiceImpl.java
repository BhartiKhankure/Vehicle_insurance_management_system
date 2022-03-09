package com.edu.VehicleManagementAppSpringBoot.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.edu.VehicleManagementAppSpringBoot.entity.Admin;
import com.edu.VehicleManagementAppSpringBoot.exception.ResourceNotFound;
import com.edu.VehicleManagementAppSpringBoot.repository.AdminRepository;
import com.edu.VehicleManagementAppSpringBoot.service.AdminService;

@Service
public class AdminServiceImpl implements AdminService {

	private AdminRepository adminRepository;

	public AdminServiceImpl(AdminRepository adminRepository) {
		super();
		this.adminRepository = adminRepository;
	}

	@Override
	public Admin saveAdmin(Admin admin) {
		return adminRepository.save(admin);
	}

	@Override
	public List<Admin> getAllAdmin() {
		return adminRepository.findAll();
	}

	@Override
	public Admin getAdminById(long Id) {
		Optional<Admin> admin = adminRepository.findById(Id);
		if (admin.isPresent()) {
			return admin.get();
		} else {
			throw new ResourceNotFound("admin", "Id", Id);
		}

	}

	@Override
	public void deleteAdmin(long Id) {
		adminRepository.findById(Id).orElseThrow(() -> new ResourceNotFound("Admin", "Id", Id));

		adminRepository.deleteById(Id);
	}

	@Override
	public Admin updateAdmin(Admin admin, long id) {
		Admin adm = new Admin();
		try {
			adm = adminRepository.findById(id).orElseThrow(() -> new ResourceNotFound("Admin", "Id", id));
		} catch (ResourceNotFound e) {
			e.printStackTrace();
		}

		adm.setPassword(admin.getPassword());
		

		adminRepository.save(adm);
		return adm;
	}

}
