package feirafacil.api.Controllers;

import feirafacil.api.Domain.Entities.Consumer;
import feirafacil.api.Domain.Requests.CreateConsumerRequest;
import feirafacil.api.Repositories.IConsumerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController // Anotação mais adequada para controllers REST, substituindo @Controller
@RequestMapping("/consumers") // Definindo o caminho base para os métodos
public class ConsumerController {

    private final IConsumerRepository consumerRepository;
    private final Validator _validator;

    @Autowired
    public ConsumerController(IConsumerRepository consumerRepository, Validator _validator) {
        this.consumerRepository = consumerRepository;
        this._validator = _validator;
    }

    // Create - Método para criar um novo consumidor
    @PostMapping
    public ResponseEntity<?> createConsumer(@RequestBody CreateConsumerRequest request) {
        // Validação do request
        if (!_validator.validateConsumerRequest(request)) {
            return ResponseEntity.badRequest().body("Dados inválidos");
        }

        // Mapeia CreateConsumerRequest para Consumer
        Consumer consumer = new Consumer();
        consumer.setName(request.name());
        consumer.setEmail(request.email());
        consumer.setCpfOrCnpj(request.cpfOrCnpj());
        consumer.setPhone(request.phone());
        consumer.setPassword(request.password());

        // Salva o consumidor no banco
        try {
            consumerRepository.save(consumer);
            return ResponseEntity.ok("Consumidor criado com sucesso");
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Erro ao salvar o consumidor");
        }
    }

    // Read - Método para obter informações do consumidor pelo ID
    @GetMapping("/{id}")
    public ResponseEntity<?> getConsumerInfos(@PathVariable Long id) {
        Optional<Consumer> consumer = consumerRepository.findById(id);
        return consumer
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Update - Método para atualizar um consumidor existente
    @PutMapping("/{id}")
    public ResponseEntity<?> updateConsumer(@PathVariable Long id, @RequestBody CreateConsumerRequest request) {
        // Validação do request
        if (!_validator.validateConsumerRequest(request)) {
            return ResponseEntity.badRequest().body("Dados inválidos");
        }

        Optional<Consumer> existingConsumer = consumerRepository.findById(id);
        if (existingConsumer.isPresent()) {
            Consumer consumer = existingConsumer.get();
            consumer.setName(request.name());
            consumer.setEmail(request.email());
            consumer.setCpfOrCnpj(request.cpfOrCnpj());
            consumer.setPhone(request.phone());
            consumer.setPassword(request.password());

            try {
                consumerRepository.save(consumer);
                return ResponseEntity.ok("Consumidor atualizado com sucesso");
            } catch (Exception e) {
                return ResponseEntity.status(500).body("Erro ao atualizar o consumidor");
            }
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Delete - Método para deletar um consumidor pelo ID
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteConsumer(@PathVariable Long id) {
        if (consumerRepository.existsById(id)) {
            try {
                consumerRepository.deleteById(id);
                return ResponseEntity.ok("Consumidor deletado com sucesso");
            } catch (Exception e) {
                return ResponseEntity.status(500).body("Erro ao deletar o consumidor");
            }
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
