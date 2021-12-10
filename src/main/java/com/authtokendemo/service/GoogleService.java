package com.authtokendemo.service;

import com.authtokendemo.model.Employee;
import com.authtokendemo.model.dto.GoogleLoginDto;
import java.io.IOException;

public interface GoogleService {

    Employee getEmployeeFromToken(GoogleLoginDto googleLoginDto) throws IOException;
}
