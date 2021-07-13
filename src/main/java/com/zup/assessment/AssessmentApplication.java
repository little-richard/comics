package com.zup.assessment;

import com.zup.assessment.infra.repository.UsuarioJpaRepository;
import com.zup.assessment.infra.repository.UsuarioRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

@EnableFeignClients
@SpringBootApplication
public class AssessmentApplication {

    @Autowired
    private UsuarioJpaRepository usuarioJpaRepository;

    public static void main(String[] args) {
        SpringApplication.run(AssessmentApplication.class, args);
    }

    @Bean
    public UsuarioRepositoryImpl usuarioRepository() {
        return new UsuarioRepositoryImpl(usuarioJpaRepository);
    }

}
