package org.stajkovic.ufc.cv.fighter.model;

import jakarta.persistence.*;
import lombok.*;
import org.stajkovic.ufc.cv.country.model.Country;

import java.time.LocalDate;

@Entity
@Table(name = "fighters")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Fighter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "countryId")
    private Country country;

    @Column(name = "name")
    private String name;

    @Column(name = "nickname")
    private String nickname;

    @Column(name = "wins")
    private int wins;

    @Column(name = "losses")
    private int losses;

    @Column(name = "draws")
    private int draws;

    @Column(name = "height_cm")
    private double height;

    @Column(name = "weight_in_kg")
    private double weight;

    @Column(name = "reach_in_cm")
    private double reach;

    @Column(name = "stance")
    @Enumerated(EnumType.STRING)
    private Stance stance;

    @Column(name = "date_of_birth")
    private LocalDate dateOfBirth;

    @Column(name = "significant_strikes_landed_per_minute")
    private double significantStrikesLanded;

    @Column(name = "significant_striking_accuracy")
    private double significantStrikesAccuracy;

    @Column(name = "significant_strikes_absorbed_per_minute")
    private double significantStrikesAbsorbed;

    @Column(name = "significant_strike_defence")
    private double significantStrikesDeffence;

    @Column(name = "average_takedowns_landed_per_15_minutes")
    private double avgTakedownsLanded;

    @Column(name = "takedown_accuracy")
    private double takedownAccuracy;

    @Column(name = "takedown_defense")
    private double takedownDefense;

    @Column(name = "average_submissions_attempted_per_15_minutes")
    private double avgSubmissionsAttempted;



}
