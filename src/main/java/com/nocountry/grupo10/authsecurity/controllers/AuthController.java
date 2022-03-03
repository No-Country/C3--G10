package com.nocountry.grupo10.authsecurity.controllers;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import javax.validation.Valid;

import com.nocountry.grupo10.authsecurity.payload.request.LoginRequest;
import com.nocountry.grupo10.authsecurity.payload.request.SignupRequest;
import com.nocountry.grupo10.authsecurity.payload.response.JwtResponse;
import com.nocountry.grupo10.authsecurity.payload.response.MessageResponse;
import com.nocountry.grupo10.authsecurity.security.services.UserDetailsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.nocountry.grupo10.authsecurity.security.jwt.JwtUtils;
import com.nocountry.grupo10.model.entity.AppUser;
import com.nocountry.grupo10.model.entity.Role;
import com.nocountry.grupo10.model.entity.RoleType;
import com.nocountry.grupo10.repository.AppUserRepository;
import com.nocountry.grupo10.repository.RoleRepository;
import javax.servlet.http.HttpSession;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;


/**
 * Clase controlador encargada del signup y login
 * @author NoCountry-G10
 * @version 1.0
 */
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class AuthController {
	@Autowired
	AuthenticationManager authenticationManager;
	@Autowired
	AppUserRepository appUserRepository;
	@Autowired
	RoleRepository roleRepository;
	@Autowired
	PasswordEncoder encoder;
	@Autowired
	JwtUtils jwtUtils;
	@PostMapping("/signin")
	public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {
		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));
		SecurityContextHolder.getContext().setAuthentication(authentication);
		String jwt = jwtUtils.generateJwtToken(authentication);
		
		UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
		List<String> roles = userDetails.getAuthorities().stream()
				.map(item -> item.getAuthority())
				.collect(Collectors.toList());
		return ResponseEntity.ok(new JwtResponse(jwt,
												 userDetails.getId(), 
												 userDetails.getUsername(), 
												 userDetails.getEmail(), 
												 roles));
	}
	@PostMapping("/signup")
	public ResponseEntity<?> registerUser(@Valid @RequestBody SignupRequest signUpRequest) {
		if (appUserRepository.existsByUsername(signUpRequest.getUsername())) {
			return ResponseEntity
					.badRequest()
					.body(new MessageResponse("Error: Username is already taken!"));
		}
		if (appUserRepository.existsByEmail(signUpRequest.getEmail())) {
			return ResponseEntity
					.badRequest()
					.body(new MessageResponse("Error: Email is already in use!"));
		}
		// Create new user's account
		AppUser appUser = new AppUser();

		appUser.setUsername(signUpRequest.getUsername());
		appUser.setEmail(signUpRequest.getEmail());
		appUser.setPassword(encoder.encode(signUpRequest.getPassword()));
		appUser.setName(signUpRequest.getName());
		appUser.setLastName(signUpRequest.getLastName());
		appUser.setPhoneNumber(signUpRequest.getPhoneNumber());
		appUser.setDocument(signUpRequest.getDocument());
		appUser.setAddress(signUpRequest.getAddress());
		appUser.setBirthdate(string2LocalDate(signUpRequest.getBirthdate()));


		Set<String> strRoles = signUpRequest.getRole();
		Set<Role> roles = new HashSet<>();
		if (strRoles == null || strRoles.isEmpty()) {
			Role userRole = roleRepository.findByName(RoleType.ROLE_USER)
					.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
			roles.add(userRole);
		} else {
			strRoles.forEach(role -> {
				switch (role) {
				case "admin":
					Role adminRole = roleRepository.findByName(RoleType.ROLE_ADMIN)
							.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
					roles.add(adminRole);
					break;
				default:
					Role userRole = roleRepository.findByName(RoleType.ROLE_USER)
							.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
					roles.add(userRole);
				}
			});
		}
		appUser.setRoles((Set<Role>) roles);
		appUserRepository.save(appUser);
		return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
	}
        
    @PutMapping("/modificar")
    public ResponseEntity<Object> moddificarUser(@PathVariable String email, 
            @RequestParam(value = "name", required = false) String name, 
            @RequestParam(value = "username", required = false) String username) {
        System.out.println("username = " + username);
        return new ResponseEntity<>(username + " " + name + " " + username, HttpStatus.OK);

    }

    @GetMapping("/logout")
    public String logout(HttpSession session){
        session.removeAttribute("idUser");
        return "redict:/";
    }

	private LocalDate string2LocalDate (String stringDate){
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
		LocalDate date = LocalDate.parse(stringDate, formatter);
		return date;
	}
}