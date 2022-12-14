package org.dione.articlecatalog.repository;

import org.dione.articlecatalog.model.RetailSale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RetailSaleRepository extends JpaRepository<RetailSale, Long> {
}
