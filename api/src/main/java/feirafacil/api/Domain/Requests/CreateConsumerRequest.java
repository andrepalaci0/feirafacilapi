package feirafacil.api.Domain.Requests;

import java.time.LocalDate;

public record CreateConsumerRequest(
        String name,
        String email,
        LocalDate birthDate,
        String cpfOrCnpj,
        String phone,
        String password
) {}
