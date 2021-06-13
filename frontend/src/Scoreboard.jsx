import React, { useState, useEffect } from "react";
import {useHistory} from "react-router-dom";
import axios from "axios";

import './Scoreboard.css'

import { Spinner } from "react-bootstrap";

export const Scoreboard = () => {
    const [teams, setTeams] = useState();
    let history = useHistory();

    useEffect(() => {
        const getTeamsData = () => {
            axios
            .get(`http://localhost:8080/scoreboard`)
            .then((res) => {
                const responseTeams = res.data;
                setTeams(responseTeams);
            });
        }
        getTeamsData();
    }, []);

    

    const renderHeader = () => {
        let headerElement = ['no.', 'name', 'g', 'p', 'w', 'd', 'l', 's', 'c'];

        return headerElement.map((key, index) => {
            return <th key={index}>{key.toUpperCase()}</th>
        })
    }

    const renderBody = () => {
        return teams &&
            teams.map(({ id, teamName, numberOfGames, points, wins, draws, loses, goalsScored, goalsConceded }, index) => {
                return (
                    <tr key={id} onClick={() => history.push(`/team/${id}`)}>
                        <td>{index+1}</td>
                        <td>{teamName}</td>
                        <td>{numberOfGames}</td>
                        <td>{points}</td>
                        <td>{wins}</td>
                        <td>{draws}</td>
                        <td>{loses}</td>
                        <td>{goalsScored}</td>
                        <td>{goalsConceded}</td>
                    </tr>
                )
            })
    }

    console.log(teams);
    return (
        <>
            {teams ? (
                <div>
                <h1 class='title'>Scoreboard</h1>
                <table id='team'>
                    <thead>
                        <tr>{renderHeader()}</tr>
                    </thead>
                    <tbody>
                        {renderBody()}
                    </tbody>
                </table>
            </div>
            ) : (
                <Spinner />
            )
            }
        </>
        
    );
}