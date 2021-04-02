package io.github.matheusrdads.clientes.model.repository;

import io.github.matheusrdads.clientes.model.entity.Servico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServicoRepository extends JpaRepository<Servico, Integer> {
}
