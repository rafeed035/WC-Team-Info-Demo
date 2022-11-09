package com.rafeed.wcteaminfodemo.Enity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

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
            nullable = false,
            unique = true
    )
    private String teamGroup;
}
