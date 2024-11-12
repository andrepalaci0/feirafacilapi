package feirafacil.api.Domain.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
@Getter
@Setter
@Entity
public class Consumer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    private String name;
    private String email;
    private String cpfOrCnpj;
    private String phone;
    private String password;

    // Getters e Setters

    // Construtores, se necessário
}
