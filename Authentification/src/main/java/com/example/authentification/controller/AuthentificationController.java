package com.example.authentification.controller;

import com.example.authentification.models.ApplicationUser;
import com.example.authentification.models.LoginResponseDTO;
import com.example.authentification.models.RegistrationDTO;
import com.example.authentification.services.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;
@RestController
@RequestMapping("/auth")
public class AuthentificationController {

    @Autowired
    private AuthenticationService authenticationService;

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@Valid @RequestBody RegistrationDTO body){
        try {
            ApplicationUser user = authenticationService.registerUser(body.getUsername(), body.getPassword(), body.getEmail());
            return ResponseEntity.ok(user);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDTO> loginUser(@Valid @RequestBody RegistrationDTO body) {
        LoginResponseDTO responseDTO = authenticationService.loginUser(body.getEmail(), body.getPassword());
        // Retirez l'appel à saveSuccessfulLogin
        return ResponseEntity.ok(responseDTO);
    }

    @PostMapping("/logout")
    public ResponseEntity<Map<String, String>> logout() {
        // Appel du service de déconnexion
        authenticationService.logout();

        // Réponse réussie avec un objet JSON contenant un message
        Map<String, String> response = new HashMap<>();
        response.put("message", "Logged out successfully");
        return ResponseEntity.ok(response);
    }


}