package org.stajkovic.ufc.cv.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "countries")
public class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "nicename")
    private String niceName;

    @Column(name = "iso3")
    private char[] iso;
}
