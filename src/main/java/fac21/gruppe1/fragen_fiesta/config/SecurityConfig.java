package fac21.gruppe1.fragen_fiesta.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/h2-console/**").permitAll() // Zugriff auf H2-Konsole erlauben
                        .anyRequest().authenticated() // Alle anderen Endpunkte erfordern Authentifizierung
                )
                .formLogin(form -> form.defaultSuccessUrl("/h2-console", true)) // Nach Login zur H2-Konsole umleiten
                .csrf(csrf -> csrf.ignoringRequestMatchers("/h2-console/**")) // CSRF für H2 deaktivieren
                .headers(headers -> headers.frameOptions(frame -> frame.sameOrigin())); // Frames für H2 erlauben

        return http.build();
    }
}
