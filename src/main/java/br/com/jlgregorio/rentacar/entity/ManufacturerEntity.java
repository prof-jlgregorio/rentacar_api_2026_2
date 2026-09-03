package br.com.jlgregorio.rentacar.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "manufacturers")
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Getter
@Setter
public class ManufacturerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 30)
    private String name;

    @Column(name = "country", nullable = false, length = 30)
    private String country;

}
