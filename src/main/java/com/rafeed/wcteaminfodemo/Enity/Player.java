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
        name = "player_details"
)
public class Player {

    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    @Column(
            name = "player_id"
    )
    private int playerId;

    @Column(
            name = "player_name",
            nullable = false
    )
    private String playerName;

    @Column(
            name = "player_strike_rate",
            nullable = false
    )
    private double playerStrikeRate;

    @Column(
            name = "player_specification",
            nullable = false
    )
    private String playerSpecification;

    @Column(
            name = "player_score",
            nullable = false
    )
    private int playerScore;

//    @ManyToOne(
//            targetEntity = Team.class,
//            fetch = FetchType.EAGER
//    )
//    @JoinColumn(
//            name = "team_id",
//            updatable = false,
//            nullable = false
//    )
//    private Team team;
//
//    @Column(
//            name = "team_id",
//            nullable = false
//    )
//    private int teamId;
//
//    @OneToOne(
//            targetEntity = Country.class,
//            fetch = FetchType.EAGER
//    )
//    @JoinColumn(
//            name = "country_id",
//            updatable = false,
//            insertable = false
//    )
//    private Country country;
//
//    @Column(
//            name = "country_id",
//            nullable = false
//    )
//    private int countryId;
}
