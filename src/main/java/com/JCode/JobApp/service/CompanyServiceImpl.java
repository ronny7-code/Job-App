package com.JCode.JobApp.service;

import com.JCode.JobApp.entity.Company;
import com.JCode.JobApp.repository.CompanyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CompanyServiceImpl implements CompanyService{

    private final CompanyRepository companyRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Company> getAllCompanies() {
        return companyRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Company getCompanyById(Long id) {
        return companyRepository.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public Company createCompany(Company company) {
        return companyRepository.save(company);
    }

    @Override
    @Transactional
    public Company updateCompany(Long id, Company newCompany) {
        Company existingComp = getCompanyById(id);
        if(existingComp == null){
            return null;
        }

        existingComp.setName(newCompany.getName());
        existingComp.setLocation(newCompany.getLocation());
        existingComp.setDescription(newCompany.getDescription());

        return companyRepository.save(existingComp);
    }

    @Override
    @Transactional
    public boolean deleteCompany(Long id) {
        if(companyRepository.existsById(id)){
            companyRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
