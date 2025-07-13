package com.examenfinal.ms_auth.dto;

import com.examenfinal.ms_auth.entity.Rol;
import lombok.Data;

@Data
public class RegistroRequest {
    private String nombre;
    private String email;
    private String password;
    private Rol rol;
}