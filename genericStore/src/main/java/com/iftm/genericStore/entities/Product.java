package com.iftm.genericStore.entities;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Document(collection = "product")
public class Product {

    @Id
    private String id;
    private String name;
    private Integer inventory;
    private Double price;
}