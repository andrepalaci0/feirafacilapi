package feirafacil.api.Repositories;

import feirafacil.api.Domain.Entities.Consumer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IConsumerRepository extends JpaRepository<Consumer, Long> {
}
