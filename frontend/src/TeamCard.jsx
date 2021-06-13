import React from "react";

import "./TeamCard.css"

const TeamCard = (props) => {
    const {team} = props;
    const {teamName, yearOfCreation, fullAddress} = team;
    console.log(team);
    return (
        <div id="team">
            <h5>Team name: {teamName}</h5>
            <h5>Year of creation: {yearOfCreation}</h5>
            <h5>Address: {fullAddress}</h5>
        </div>
    );
}

export default TeamCard;