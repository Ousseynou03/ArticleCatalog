package org.dione.articlecatalog.repository;

import org.dione.articlecatalog.model.Sale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface SaleRepository extends JpaRepository<Sale, Long>{
}
