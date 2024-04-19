package gioelefriggia.u5v3d5.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(authorize -> authorize
                        .requestMatchers("/public/").permitAll()  // Accesso libero a tutti
                        .requestMatchers("/user/").hasRole("USER")  // Solo gli utenti normali
                        .requestMatchers("/admin/**").hasRole("ADMIN")  // Solo gli organizzatori di eventi
                        .anyRequest().authenticated())  // Tutte le altre richieste autenticate
                // Disabilita il contesto di sicurezza se non utilizzato
                .securityContext(context -> context.disable())
                // Disabilita la cache delle richieste se non utilizzata
                .requestCache(cache -> cache.disable())
                // Lascia la configurazione degli header di default per evitare deprecazioni
                // Disabilita la gestione predefinita del logout
                .logout(logout -> logout.disable());

        return http.build();
    }
}