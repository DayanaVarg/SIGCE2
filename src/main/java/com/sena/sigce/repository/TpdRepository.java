package com.sena.sigce.repository;

import com.sena.sigce.model.Articulo;
import com.sena.sigce.model.TipoDecision;
import org.springframework.data.repository.CrudRepository;

public interface TpdRepository extends CrudRepository<TipoDecision, Integer> {
}
