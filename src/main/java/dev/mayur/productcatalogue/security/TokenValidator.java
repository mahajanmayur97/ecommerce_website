package dev.mayur.productcatalogue.security;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@Service
public class TokenValidator {
    private RestTemplateBuilder restTemplateBuilder;

    public TokenValidator(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplateBuilder = restTemplateBuilder;
    }

    /**
     * Calls user service to validate the token.
     * If token is not valid, optional is empty.
     * Else optional contains all of the data in payload
     * @param token
     * @return
     */
    public Optional<Boolean> validateToken(String token) {
        System.out.println("Inside PS-validateToken");
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<Boolean> response = restTemplate.postForEntity("http://localhost:8080/auth/validate1", token, Boolean.class );
        return Optional.of(response.getBody());
    }
}
