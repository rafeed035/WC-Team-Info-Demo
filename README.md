# WC-Team-Info-Demo
This is a project that will store the T20 World Cup participating countries, the teams and the players.
In this project RESTful services are implemented using Spring Boot. For security, Spring Security and JWT authentication is implemented.
PostgreSQL is used as the database.

The Enities are:
1. Country
2. Team
3. Player
4. User

The endpoints are:

For Authentication:

/auth/login      ---> to login and get the access token


For Country:

/api/v1/country/save        ---> to save
/api/v1/country/getById     ---> to get country by id
/api/v1/country/getByName   ---> to get country by name
/api/v1/country/getAll      ---> to get all countries
/api/v1/country/update      ---> to update a country
/api/v1/country/delete      ---> to delete a country


For Team:

/api/v1/team/save             ---> to save team
/api/v1/team/getById          ---> to get team  by id
/api/v1/team/getByName        ---> to get team by name
/api/v1/team/getByCountry     ---> to get team by country
/api/v1/team/getAll           ---> to get all teams
/api/v1/team/update           ---> to update a team
/api/v1/team/delete           ---> to delete a team


For Player:

/api/v1/player/save           ---> to save player
/api/v1/player/getById        ---> to get player by id
/api/v1/player/getByName      ---> to get player by name
/api/v1/player/getByTeam      ---> to get player by team
/api/v1/player/getByCountry   ---> to get player by country
/api/v1/player/getByScore     ---> to get player by score
/api/v1/player/getAll         ---> to get all players
/api/v1/player/update         ---> to update a player
/api/v1/player/delete         ---> to delete a player



