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

1. /auth/login      ---> to login and get the access token


For Country:

1. /api/v1/country/save        ---> to save
2. /api/v1/country/getById     ---> to get country by id
3. /api/v1/country/getByName   ---> to get country by name
4. /api/v1/country/getAll      ---> to get all countries
5. /api/v1/country/update      ---> to update a country
6. /api/v1/country/delete      ---> to delete a country


For Team:

1. /api/v1/team/save             ---> to save team
2. /api/v1/team/getById          ---> to get team  by id
3. /api/v1/team/getByName        ---> to get team by name
4. /api/v1/team/getByCountry     ---> to get team by country
5. /api/v1/team/getAll           ---> to get all teams
6. /api/v1/team/update           ---> to update a team
7. /api/v1/team/delete           ---> to delete a team


For Player:

1. /api/v1/player/save           ---> to save player
2. /api/v1/player/getById        ---> to get player by id
3. /api/v1/player/getByName      ---> to get player by name
4. /api/v1/player/getByTeam      ---> to get player by team
5. /api/v1/player/getByCountry   ---> to get player by country
6. /api/v1/player/getByScore     ---> to get player by score
7. /api/v1/player/getAll         ---> to get all players
8. /api/v1/player/update         ---> to update a player
9. /api/v1/player/delete         ---> to delete a player

Only the endpoints "/auth/login" and "/api/v1/user/save" can be used without any access token.
The rest other endpoints need access token as "Authorization" header in the following manner.

"Authorization: Bearer >token<"

