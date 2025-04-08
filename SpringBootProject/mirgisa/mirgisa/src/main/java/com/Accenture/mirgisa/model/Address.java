package com.Accenture.mirgisa.model;

import jakarta.persistence.*;
import lombok.*;


@Entity
@Data
@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long address_id;

    private String address;

    private String district;

    private String location;


}
