import React, { useState, useEffect } from "react";
import axios from "axios";

import { TeamCard } from "./TeamCard";
import { Spinner } from "react-bootstrap";

export const TeamList = () => {
    const [teams, setTeams] = useState();

    useEffect(() => {
        axios
            .get(`http://localhost:8080/team/all`)
            .then((res) => {
                const responseTeams = res.data;
                setTeams(responseTeams);
            });
    }, []);

    return (
        <>
            <h4> Teams: </h4>
            {teams ? (
                <div style={{
                    display: "flex",
                    flexWrap: "wrap"
                }}>
                    {teams.map((team) => (
                        <TeamCard team={team} />
                    ))}
                </div>
            ) : (
                <Spinner />
            )
            }
        </>
    );
}