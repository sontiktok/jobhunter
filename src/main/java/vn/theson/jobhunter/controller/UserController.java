package vn.theson.jobhunter.controller;

import com.turkraft.springfilter.boot.Filter;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import vn.theson.jobhunter.entity.User;
import vn.theson.jobhunter.entity.dto.ResultPaginationDTO;
import vn.theson.jobhunter.service.UserService;
import vn.theson.jobhunter.util.annotation.ApiMessage;
import vn.theson.jobhunter.util.error.IdInvalidException;

import java.util.List;
import java.util.Optional;

@RestController
public class UserController {

    private final UserService userService;

    private final PasswordEncoder passwordEncoder;

    public UserController(UserService userService, PasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping("/users")
    public ResponseEntity<User> createUser(@RequestBody User user) {
        String hashedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(hashedPassword);
        User newUser = this.userService.handleCreateUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(newUser);
    }


    @DeleteMapping("/users/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable long id) throws IdInvalidException {
        if(id > 1500){
            throw
        new IdInvalidException("Id khong ton tai");
        }
        this.userService.handleDeleteUser(id);
        //return ResponseEntity.status(HttpStatus.OK).body("User deleted successfully");
        return ResponseEntity.ok("User deleted successfully");
    }

    @GetMapping("/users")
    @ApiMessage("Fetch all users")
    public ResponseEntity<ResultPaginationDTO> getAllUser(
            @Filter Specification<User> spec,
            Pageable pageable
        ) {
//        String sCurrent = currentOptional.isPresent() ? currentOptional.get() : "";
//        String sPageSize = pageSizeOptional.isPresent() ? pageSizeOptional.get() : "";
//        int current = Integer.parseInt(sCurrent);
//        int pageSize = Integer.parseInt(sPageSize);
//        Pageable pageable = PageRequest.of(current-1, pageSize);
        return ResponseEntity.status(HttpStatus.OK).body(this.userService.fetchAllUser(spec,pageable));
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<User> getUserById(@PathVariable long id) {
        User fetchUser =  this.userService.fetchUserById(id);
        return ResponseEntity.status(HttpStatus.OK).body(fetchUser);
    }


    @PutMapping("/users")
    public ResponseEntity<User> updateUser(@RequestBody User user) {
        User fetchUser =  this.userService.handleUpdateUser(user);
        return ResponseEntity.status(HttpStatus.OK).body(fetchUser);
    }


}
