package feirafacil.api.Services;

import feirafacil.api.Domain.Entities.Consumer;
import feirafacil.api.Repositories.IConsumerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ConsumerService {

    private final IConsumerRepository consumerRepository;

    @Autowired
    public ConsumerService(IConsumerRepository consumerRepository) {
        this.consumerRepository = consumerRepository;
    }

    // Método para criar um novo consumidor
    public Consumer createConsumer(Consumer consumer) {
        return consumerRepository.save(consumer);
    }

    // Método para buscar um consumidor pelo ID
    public Optional<Consumer> getConsumerById(Long id) {
        return consumerRepository.findById(id);
    }

    // Método para buscar um consumidor pelo email
    public Optional<Consumer> getConsumerByEmail(String email) {
        return consumerRepository.findByEmail(email);
    }

    // Método para atualizar um consumidor
    public Consumer updateConsumer(Long id, Consumer updatedConsumer) {
        Optional<Consumer> existingConsumer = consumerRepository.findById(id);
        if (existingConsumer.isPresent()) {
            Consumer consumer = existingConsumer.get();
            consumer.setName(updatedConsumer.getName());
            consumer.setEmail(updatedConsumer.getEmail());
            consumer.setCpfOrCnpj(updatedConsumer.getCpfOrCnpj());
            consumer.setPhone(updatedConsumer.getPhone());
            consumer.setPassword(updatedConsumer.getPassword());
            return consumerRepository.save(consumer);
        } else {
            throw new IllegalArgumentException("Consumidor com o ID especificado não encontrado.");
        }
    }

    // Método para excluir um consumidor pelo ID
    public void deleteConsumer(Long id) {
        if (consumerRepository.existsById(id)) {
            consumerRepository.deleteById(id);
        } else {
            throw new IllegalArgumentException("Consumidor com o ID especificado não encontrado.");
        }
    }

    // Método para listar todos os consumidores
    public List<Consumer> getAllConsumers() {
        return consumerRepository.findAll();
    }
}
