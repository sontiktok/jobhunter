package vn.theson.jobhunter.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.theson.jobhunter.entity.Company;

public interface CompanyRepository extends JpaRepository<Company, Long> {
}
