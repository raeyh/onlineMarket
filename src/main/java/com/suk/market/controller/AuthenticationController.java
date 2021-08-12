package com.suk.market.controller;

import com.suk.market.configuration.security.userDetails.AppUserDetailsService;
import com.suk.market.domain.*;
import com.suk.market.dto.AuthenticationRequest;
import com.suk.market.dto.AuthenticationResponse;
import com.suk.market.dto.UserDTO;
import com.suk.market.service.buyer.BuyerService;
import com.suk.market.service.role.RoleService;
import com.suk.market.service.seller.SellerService;
import com.suk.market.service.user.UserService;
import com.suk.market.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping
public class AuthenticationController {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private AppUserDetailsService appUserDetailsService;

    @Autowired
    private BuyerService buyerService;

    @Autowired
    private SellerService sellerService;

    @Autowired
    private RoleService roleService;
    @Autowired
    private UserService userService;


    @Autowired
    private JwtUtil jwtTokenUtil;

    @PostMapping("/authenticate")
    public ResponseEntity<?> createAuthToken(@RequestBody AuthenticationRequest authenticationRequest)
            throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                    authenticationRequest.getUsername(), authenticationRequest.getPassword()));
        } catch (DisabledException e) {
            throw new Exception("USER DISABLED", e);
        } catch (BadCredentialsException e) {
            throw new Exception("Incorrect Username and Password", e);
        }
        final UserDetails userDetails = appUserDetailsService
                .loadUserByUsername(authenticationRequest.getUsername());
        final String jwt = jwtTokenUtil.generateToken(userDetails);

        return ResponseEntity.ok(new AuthenticationResponse(jwt));
    }

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody UserDTO userDTO) {
        if (userDTO.isBuyer()) {
            Buyer buyer = new Buyer();
            List<Address> addresses = new ArrayList<>();
            List<Review> reviews = new ArrayList<>();
            buyer.setUsername(userDTO.getUsername());
            buyer.setPassword(new BCryptPasswordEncoder().encode(userDTO.getPassword()));
            List<Role> roles = new ArrayList<>();
            roles.add(roleService.getRoleByName("ROLE_BUYER"));
            buyer.setRoles(roles);
            buyer.setFirstName(userDTO.getFirstName());
            buyer.setAddresses(addresses);
            buyer.setReviews(reviews);
            Buyer savedBuyer = buyerService.addBuyer(buyer);
            userService.save(buyer);
            System.out.println("Buyer Created!");
            return ResponseEntity.ok(savedBuyer);
        }
        if (userDTO.isSeller()) {
            Seller seller = new Seller();
            List<Product> products = new ArrayList<>();
            seller.setUsername(userDTO.getUsername());
            seller.setPassword(new BCryptPasswordEncoder().encode(userDTO.getPassword()));
            List<Role> roles = new ArrayList<>();
            roles.add(roleService.getRoleByName("ROLE_SELLER"));
            seller.setRoles(roles);
            seller.setProducts(products);
            seller.setApproved(false);
            Seller savedSeller = sellerService.addSeller(seller);
            userService.save(seller);
            System.out.println("Seller Created!");
            return ResponseEntity.ok(savedSeller);
        }
        return ResponseEntity.ok("User Created");
    }


}
