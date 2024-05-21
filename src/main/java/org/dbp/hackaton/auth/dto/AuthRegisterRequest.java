package org.dbp.hackaton.auth.dto;

import lombok.Data;

@Data
public class AuthRegisterRequest {
    String name;
    String email;
    String password;
    String telefono;
}