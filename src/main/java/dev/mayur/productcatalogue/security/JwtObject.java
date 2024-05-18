package dev.mayur.productcatalogue.security;

import dev.mayur.productcatalogue.dtos.Role;
import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
public class JwtObject {
    private String email;
    private Long userId;
    private Date createdAt;
    private Date expiryAt;
    private List<Role> roles = new ArrayList<>();
}
