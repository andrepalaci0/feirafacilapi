package feirafacil.api.Repositories;

import feirafacil.api.Domain.Entities.Consumer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IConsumerRepository extends JpaRepository<Consumer, Long> {
}
