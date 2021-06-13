import React, { useState, useEffect } from "react";
import axios from "axios";
import { useParams, useHistory } from "react-router-dom";
import { Spinner } from "react-bootstrap";

import TeamCard from  './TeamCard';

import './TeamCard.css'

export const Team = () => {
    const { id } = useParams();
    const [team, setTeam] = useState();
    const [players, setPlayers] = useState();
    const [games, setGames] = useState();

    const getDataFromServer = () => {
        axios
        .get(`http://localhost:8080/team/${id}`)
        .then((res) => {
            const responseTeam = res.data;
            setTeam(responseTeam);
        });

    axios
        .get(`http://localhost:8080/player/byClubId/${id}`)
        .then((res) => {
            const responsePlayers = res.data;
            setPlayers(responsePlayers);
        });

    axios
        .get(`http://localhost:8080/game/byClubId/${id}`)
        .then((res) => {
            const responseGames = res.data;
            setGames(responseGames);
        });
    }

    useEffect(getDataFromServer, []);

    return (
        <div>
            {team ? (
                <div>
                    <TeamCard team={team}/>
                </div>
            ) : (
                <Spinner />
            )}
            <h2 id="header-center">Players:</h2>
            {players ? (
                <div style={{
                    display: "flex",
                    flexWrap: "wrap",

                }}>
                    {players.map((player) => (
                        <PlayerInList player={player} />
                    ))}
                </div>
            ) : (
                <Spinner />
            )
            }
            <h2 id="header-center">Games:</h2>
            {games ? (
                <div style={{
                    display: "flex",
                    flexWrap: "wrap",
                    display: "block",
                    marginLeft: "auto",
                    marginRight: "auto"
                }}>
                    {games.map((game) => (
                        <GameInList game={game} />
                    ))}
                </div>
            ) : (
                <Spinner />
            )
            }
        </div>
    );
}

const PlayerInList = (props) => {
    const { player } = props;
    const { fullName, birthDate, mainPositionName } = player;


    return (
        <div style={{
            background: "#8EA604",
            margin: "10px",
            padding: "15px",
            width: "200px",
            borderRadius: "15px"
        }}>
            <h5>{fullName} {birthDate} {mainPositionName}</h5>
        </div>
    );
}


const GameInList = (props) => {
    const { game } = props;
    const {id, hostScore, guestScore, gameDate, hostTeamName, guestTeamName, refereeFullName} = game;

    let history = useHistory();

    return (
        <div style={{
            background: "#F5BB00",
            margin: "10px",
            width: "800px",
            textAlign: "center",
            display: "block",
            marginLeft: "auto",
            marginRight: "auto"
        }}
        onClick={() => history.push(`/game/${id}`)}>
            {<h5>{hostTeamName} {hostScore} : {guestScore} {guestTeamName} [{gameDate}r.] referee: {refereeFullName}</h5>}
        </div>
    );
}