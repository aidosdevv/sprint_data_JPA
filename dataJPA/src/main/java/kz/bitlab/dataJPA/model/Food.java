package kz.bitlab.dataJPA.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "foods")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Food {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private int calories;
    private int amounts;
    private int price;

    @JoinColumn(name = "manufacturer_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Manufacturer manufacturer;
}
