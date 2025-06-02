package org.stajkovic.ufc.cv.fighter.model;

import jakarta.persistence.*;
import lombok.*;
import org.stajkovic.ufc.cv.country.model.Country;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "fighters")
@Getter
@Setter
@NoArgsConstructor
@Builder
@AllArgsConstructor
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
    private BigDecimal height;

    @Column(name = "weight_in_kg")
    private BigDecimal weight;

    @Column(name = "reach_in_cm")
    private BigDecimal reach;

    @Column(name = "stance")
    @Enumerated(EnumType.STRING)
    private Stance stance;

    @Column(name = "date_of_birth")
    private LocalDate dateOfBirth;

    @Column(name = "significant_strikes_landed_per_minute")
    private BigDecimal significantStrikesLanded;

    @Column(name = "significant_striking_accuracy")
    private BigDecimal significantStrikesAccuracy;

    @Column(name = "significant_strikes_absorbed_per_minute")
    private BigDecimal significantStrikesAbsorbed;

    @Column(name = "significant_strike_defence")
    private BigDecimal significantStrikesDeffence;

    @Column(name = "average_takedowns_landed_per_15_minutes")
    private BigDecimal avgTakedownsLanded;

    @Column(name = "takedown_accuracy")
    private BigDecimal takedownAccuracy;

    @Column(name = "takedown_defense")
    private BigDecimal takedownDefense;

    @Column(name = "average_submissions_attempted_per_15_minutes")
    private BigDecimal avgSubmissionsAttempted;



}
