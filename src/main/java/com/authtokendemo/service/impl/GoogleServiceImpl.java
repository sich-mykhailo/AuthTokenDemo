package com.authtokendemo.service.impl;

import com.authtokendemo.model.Employee;
import com.authtokendemo.model.dto.GoogleLoginDto;
import com.authtokendemo.service.GoogleService;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken;
import com.google.api.client.json.jackson2.JacksonFactory;
import java.io.IOException;
import org.springframework.stereotype.Service;

@Service
public class GoogleServiceImpl implements GoogleService {

    public Employee getEmployeeFromToken(GoogleLoginDto googleLoginDto)  {
        try {
        GoogleIdToken googleToken = GoogleIdToken.parse(JacksonFactory.getDefaultInstance(),
                googleLoginDto.getGoogleToken());
            GoogleIdToken.Payload payload = googleToken.getPayload();
            Employee employee = new Employee();
            employee.setId(payload.getSubject());
            employee.setEmail(payload.getEmail());
            employee.setFirstName((String) payload.get("given_name"));
            employee.setLastName((String) payload.get("family_name"));
            employee.setStatus(Employee.Status.ACTIVE);
            return employee;
        } catch (IOException e) {
            throw new RuntimeException("Invalid ID token ", e);
        }
    }
}

