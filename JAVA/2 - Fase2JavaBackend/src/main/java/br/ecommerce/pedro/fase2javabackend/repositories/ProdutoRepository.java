package br.ecommerce.pedro.fase2javabackend.repositories;

import br.ecommerce.pedro.fase2javabackend.entities.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository  extends JpaRepository<Produto, Long> {
}
