package com.example.pharmacy_spring_boot.model;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.SoftDelete;
import org.springframework.data.jpa.repository.Query;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
@ToString(exclude = "items")
@Entity
@SoftDelete
public class Prescription {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    Patient patient;

    @ManyToMany(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    @JoinTable(
            name = "prescription_item",
            joinColumns = @JoinColumn(name = "prescription_id"),
            inverseJoinColumns = @JoinColumn(name = "item_id"))
    List<Item> items = new ArrayList<>();

    Boolean confirmed = false;
}
