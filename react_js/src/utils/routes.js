import React from "react";
import {
    Router,
    Redirect, Route,
    Switch,
} from "react-router-dom";
import { createBrowserHistory } from 'history'
import { HomeComponent } from "../components/HomeComponent";
import { BookComponent } from "../components/DetailComponent";
import { SearchComponent } from "../components/SearchComponent"

const Navigation = () => {
    return (
        <Router history={createBrowserHistory()}>
            <Switch>
                <Route
                        exact
                        path="/"
                        render={(props) => (
                            <HomeComponent {...props} />
                        )}
                    />
                <Route
                        exact
                        path="/book"
                        render={(props) => (
                            <BookComponent {...props} />
                        )}
                    />
                <Route
                        exact
                        path="/search"
                        render={(props) => (
                            <SearchComponent {...props} />
                        )}
                    />
            </Switch>
        </Router>
    );
}

export default Navigation;