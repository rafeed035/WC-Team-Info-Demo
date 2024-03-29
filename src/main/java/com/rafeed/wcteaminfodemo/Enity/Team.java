package com.rafeed.wcteaminfodemo.Enity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(
        name = "team_details"
)
public class Team {

    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    @Column(
            name = "team_id"
    )
    private int teamId;

    @Column(
            name = "team_name",
            nullable = false,
            unique = true
    )
    private String teamName;

    @Column(
            name = "team_points",
            nullable = false
    )
    private double teamPoints;

    @Column(
            name = "team_position",
            nullable = false,
            unique = true
    )
    private int teamPosition;

    @Column(
            name = "team_group",
            nullable = false
    )
    private String teamGroup;

    @JsonIgnore
    @OneToOne(
            targetEntity = Country.class,
            fetch = FetchType.EAGER
    )
    @JoinColumn(
            name = "country_id",
            updatable = false,
            insertable = false
    )
    private Country country;

    @Column(
            name = "country_id",
            nullable = false
    )
    private int countryId;
}
