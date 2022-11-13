package org.dione.articlecatalog.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.dione.articlecatalog.enums.CreditStatus;

import javax.persistence.*;
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
    @Enumerated(EnumType.STRING)
    @Column(length = 15)
    private CreditStatus creditStatus;

}
