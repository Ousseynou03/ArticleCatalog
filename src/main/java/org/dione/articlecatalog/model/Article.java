package org.dione.articlecatalog.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Data @AllArgsConstructor @NoArgsConstructor @Builder
public class Article implements Serializable {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idArticle;
    private String codeArticle;
    private String designation;
    private Integer quantity;
    private double price;
    private String imageUrl;
}
