package com.boaglio.casadocodigo.greendogdelivery.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import com.boaglio.casadocodigo.greendogdelivery.domain.Item;

@RepositoryRestResource(collectionResourceRel="itens",path="itens")
//@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {

}
