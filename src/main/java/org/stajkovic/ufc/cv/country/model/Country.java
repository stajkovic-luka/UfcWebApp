package org.stajkovic.ufc.cv.country.model;

import jakarta.persistence.*;
import lombok.*;
import org.stajkovic.ufc.cv.fighter.model.Fighter;

import java.util.List;

@Entity
@Table(name = "countries")
@NoArgsConstructor
@Getter
@Setter
@ToString(onlyExplicitlyIncluded = true)
public class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToMany(mappedBy = "country", fetch = FetchType.LAZY)
    private List<Fighter> fighterList;


    @Column(name = "name")
    @ToString.Include
    private String name;

    @Column(name = "nicename")
    @ToString.Include
    private String niceName;

    @Column(name = "iso3")
    @ToString.Include
    private String iso;
}
