import React, {useState, useEffect} from "react";
import axios from "axios";

export const TeamList = () => {
    const [teams, setTeams] = useState();

    useEffect(() => {
        axios.get(`http://localhost:8080/team/all`).then((res) => {
            const responseTeams = res.data;
            setTeams(responseTeams);
        });
    }, []);

    return (
        <div>
            <h4> Teams: </h4>
            {teams && 
                teams.map((team) => {
                const {id, teamName, yearOfCreation, fullAddress} = team;
                return (
                    <div key={id}>
                        <h5>{teamName}</h5>
                        <h5>{yearOfCreation}</h5>
                        <h6>{fullAddress}</h6>
                    </div>
                );
            })}
        </div>
    );
}