package vn.theson.jobhunter.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import vn.theson.jobhunter.entity.Company;

public interface CompanyRepository extends JpaRepository<Company, Long>, JpaSpecificationExecutor<Company> {
}
