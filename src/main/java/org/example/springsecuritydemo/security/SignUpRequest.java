package org.example.springsecuritydemo.security;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Builder;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@Builder(toBuilder = true)
@Schema(description = "Запрос на регистрацию")
public record SignUpRequest(

        @Schema(description = "Адрес электронной почты", example = "jondoe@gmail.com")
        @Size(min = 5, max = 255, message = "Адрес электронной почты должен содержать от 5 до 255 символов")
        @NotBlank(message = "Адрес электронной почты не может быть пустыми")
        @Email(message = "Email адрес должен быть в формате user@example.com")
        String email,

        @Schema(description = "Пароль", example = "my_secret_password")
        @Size(min = 8, message = "Пароль должен быть не меньше 8 символов")
        @Size(max = 32, message = "Пароль должен быть не больше 32 символов")
        String password
) {
}