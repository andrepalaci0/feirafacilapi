package feirafacil.api.Controllers;

import feirafacil.api.Domain.Requests.CreateConsumerRequest;
import org.springframework.stereotype.Component;

@Component
public class Validator {

    // Método de validação para os dados do consumidor
    public boolean validateConsumerRequest(CreateConsumerRequest request) {
        return request != null
                && isValidName(request.name())
                && isValidEmail(request.email())
                && isValidCpfOrCnpj(request.cpfOrCnpj())
                && isValidPhone(request.phone())
                && isValidPassword(request.password());
    }

    // Validação do nome (não pode ser nulo ou vazio)
    private boolean isValidName(String name) {
        return name != null && !name.trim().isEmpty();
    }

    // Validação do email (básica)
    private boolean isValidEmail(String email) {
        return email != null && email.matches("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$");
    }

    // Validação do CPF ou CNPJ (exemplo simplificado)
    private boolean isValidCpfOrCnpj(String cpfOrCnpj) {
        return cpfOrCnpj != null && cpfOrCnpj.matches("\\d{11}|\\d{14}"); // CPF: 11 dígitos | CNPJ: 14 dígitos
    }

    // Validação do telefone (exemplo simples com DDD e 9 dígitos)
    private boolean isValidPhone(String phone) {
        return phone != null && phone.matches("\\(\\d{2}\\) \\d{5}-\\d{4}");
    }

    // Validação da senha (não pode ser nula ou vazia)
    private boolean isValidPassword(String password) {
        return password != null && password.length() >= 6; // Exemplo de validação simples (senha mínima de 6 caracteres)
    }
}
