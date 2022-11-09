package com.rafeed.wcteaminfodemo.Enity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(
        name = "country_details"
)
public class Country {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    @Column(
            name = "country_id"
    )
    private int countryId;

    @Column(
            name = "country_name",
            nullable = false,
            unique = true
    )
    private String countryName;

//    @OneToOne(
//            targetEntity = Team.class,
//            fetch = FetchType.EAGER
//    )
//    @JoinColumn(
//            name = "team_id",
//            updatable = false,
//            insertable = false
//    )
//    private Team team;
//
//    @Column(
//            name = "team_id",
//            nullable = false
//    )
//    private int teamId;

    @OneToOne
    private Team team;

    @OneToMany
    private List<Player> playerList;
}
