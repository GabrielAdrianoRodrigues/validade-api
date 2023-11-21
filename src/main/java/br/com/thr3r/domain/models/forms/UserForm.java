package br.com.thr3r.domain.models.forms;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record UserForm(
    @NotBlank
    String name,
    @Email
    String email,
    @NotBlank
    String password
) {}
