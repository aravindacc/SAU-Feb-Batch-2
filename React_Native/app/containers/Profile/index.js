import { Component, PureComponent } from "react";

import React from 'react';
import {Text, View} from 'react-native';


class ProfileView extends Component {
    constructor(props) {
        super(props);
        this.state = {
            name: 'ProfilePage'
        }
    }

    render() {
        return (
            <View style={{ flex: 1, justifyContent: "center", alignItems: "center" }}>
            <Text>Profile Screen {this.state.name}</Text>
            </View>
        )
    }
}

export default ProfileView