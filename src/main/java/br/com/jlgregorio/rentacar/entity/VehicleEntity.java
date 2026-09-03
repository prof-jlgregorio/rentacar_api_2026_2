package br.com.jlgregorio.rentacar.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "vehicles")
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Setter
@Getter
public class VehicleEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 50)
    private String name;

    @Column(nullable = false)
    private int year;

    @Column(nullable = false)
    private String color;

    @Column(length = 255)
    private String comments;

    @ManyToOne
    @JoinColumn(name = "manufacturer_id", nullable = false)
    private ManufacturerEntity manufacturer;

}
