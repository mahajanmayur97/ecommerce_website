package dev.mayur.productcatalogue.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Product extends BaseModel{

     private String title;
     private String description;
     private String image;

     @ManyToOne(cascade = {CascadeType.ALL})
     @JoinColumn(name = "category")
     private Category category;

     @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.REMOVE}, fetch = FetchType.LAZY)
     private Price price;
     private int inventoryCount;
}
