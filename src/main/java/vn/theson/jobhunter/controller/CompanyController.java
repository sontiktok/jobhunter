package vn.theson.jobhunter.controller;

import com.turkraft.springfilter.boot.Filter;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.theson.jobhunter.entity.Company;
import vn.theson.jobhunter.entity.dto.ResultPaginationDTO;
import vn.theson.jobhunter.service.CompanyService;

import java.util.List;
import java.util.Optional;

@RestController
public class CompanyController {
    private final CompanyService companyService;

    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }
    // Create
    @PostMapping("/companies")
    public ResponseEntity<Company> createCompany(@Valid @RequestBody Company company) {
        return ResponseEntity.status(HttpStatus.CREATED).body(this.companyService.hanldeCreateCompany(company));
    }

    // Get
    @GetMapping("/companies")
    public ResponseEntity<ResultPaginationDTO> getCompany(
            @Filter Specification<Company> spec, Pageable pageable) {

        return ResponseEntity.ok(this.companyService.handleGetCompany(spec, pageable));
    }

    // Update
    @PutMapping("/companies")
    public ResponseEntity<Company> updateCompany(@Valid @RequestBody Company reqCompany) {
        Company updatedCompany = this.companyService.handleUpdateCompany(reqCompany);
        return ResponseEntity.ok(updatedCompany);
    }

    // Delete
    @DeleteMapping("/companies/{id}")
    public ResponseEntity<Void> deleteCompany(@PathVariable("id") long id) {
        this.companyService.handleDeleteCompany(id);
        return ResponseEntity.ok(null);
    }


}
