package com.suk.market.dto;

import com.suk.market.domain.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserDTO {
    private String firstName;
    private String lastName;
    private String email;
    private String username;
    private String password;
    private boolean isBuyer;
    private boolean isSeller;

    public User getUserFromDto() {
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setEmail(email);

        return user;
    }
}
