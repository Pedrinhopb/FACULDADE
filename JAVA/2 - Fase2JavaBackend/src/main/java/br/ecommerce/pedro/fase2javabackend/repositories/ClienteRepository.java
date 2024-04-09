package br.ecommerce.pedro.fase2javabackend.repositories;

import br.ecommerce.pedro.fase2javabackend.entities.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
