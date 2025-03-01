package com.aziz.ecommercerestapi.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(
        name = "categories"
)
public class Category {
  @Id
  @GeneratedValue(
          strategy = GenerationType.IDENTITY
  )
  private Long id;

  @Column(name = "category_name", nullable = false, unique = true)
  private String categoryName;

  @Column(name = "category_description")
  private String categoryDescription;

  @Column(name = "category_image")
  private String categoryImage;

  private int position;
  private boolean status;

  @OneToMany(
          mappedBy = "category",
          cascade = CascadeType.ALL,
          orphanRemoval = true
  )
  private Set<SubCategory> subCategories = new HashSet<>();

  @OneToMany(
          mappedBy = "category",
          cascade = CascadeType.ALL,
          orphanRemoval = true
  )
  private Set<Product> products = new HashSet<>();

}
