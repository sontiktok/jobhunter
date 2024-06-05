package vn.theson.jobhunter.service;

import org.springframework.stereotype.Service;
import vn.theson.jobhunter.entity.Company;
import vn.theson.jobhunter.repository.CompanyRepository;

@Service
public class CompanyService {

    private final CompanyRepository companyRepository;

    public CompanyService(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    public Company hanldeCreateCompany(Company company) {
        return this.companyRepository.save(company);
    }
}
