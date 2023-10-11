package com.rafeed.wcteaminfodemo.Enity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
}
