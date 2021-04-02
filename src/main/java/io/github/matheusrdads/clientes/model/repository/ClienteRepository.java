package io.github.matheusrdads.clientes.model.repository;

import io.github.matheusrdads.clientes.model.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
}

//a classe client esta sendo mapeadan pelo jpa repository e sera associada a outras classes por um id Integer
//Entity Client, Id Integer