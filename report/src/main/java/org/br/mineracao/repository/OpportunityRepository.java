package org.br.mineracao.repository;


import io.quarkus.hibernate.orm.panache.PanacheRepository;
import org.br.mineracao.entity.OpportunityEntity;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class OpportunityRepository implements PanacheRepository<OpportunityEntity> {
}
