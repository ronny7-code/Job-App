package com.JCode.JobApp.service;

import com.JCode.JobApp.entity.Company;

import java.util.List;

public interface CompanyService {

    List<Company> getAllCompanies();

    Company getCompanyById(Long id);

    Company createCompany(Company company);

    Company updateCompany(Long id, Company newCompany);

    boolean deleteCompany(Long id);

}
