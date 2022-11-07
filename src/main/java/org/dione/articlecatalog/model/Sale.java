package org.dione.articlecatalog.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor @Builder
public class Sale implements Serializable {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idSale;
    private String Customer;
    private double delivery;
    private double total;
    private double advance;
    private String creditStatus;

}
