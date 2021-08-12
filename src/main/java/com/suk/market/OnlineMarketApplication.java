package com.suk.market;

import com.suk.market.domain.Role;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class OnlineMarketApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(OnlineMarketApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        addRoles();

    }

    private void addRoles() {
        Role admin = new Role(1, "ROLE_ADMIN");
        Role buyer = new Role(1, "ROLE_BUYER");
        Role seller = new Role(1, "ROLE_SELLER");
    }

}
