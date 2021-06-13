import './App.css';
import { Team } from './Team';
import {Scoreboard} from "./Scoreboard";

import { BrowserRouter as Router, Switch, Route } from "react-router-dom";

function App() {
  return (
    <Router>
      <Switch>
        <Route exact path="/" children={<Scoreboard />} />
        <Route exact path="/team/:id" children={<Team />} />
      </Switch>
    </Router>
  );
}

export default App;
