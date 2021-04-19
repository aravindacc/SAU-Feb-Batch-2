import React, { useEffect, useState } from "react";
import "./App.css";
import { BrowserRouter as Router, Switch, Route, Link } from "react-router-dom";
import Home from './components/Home';
import Books from './components/Books';

function App() {
  return (
    <Router>
      <Switch>
        
        <Route exact path="/book" component = {Books}/>
         
        {/* <Route path="/" component = {Home}/> */}
        
        <Route exact path="/home" component = {Home}/>
          
        <Link to={{ pathname: "/home"}}>
          <div>
            <div className = "fronttext">
              <h1> Accolite's Reader's Park </h1>
            </div>
            <div class = "apppage">
              <h1> Click to view all books </h1>
            </div>
          </div>
          </Link>
      </Switch>
    </Router>
  );
}

export default App;
