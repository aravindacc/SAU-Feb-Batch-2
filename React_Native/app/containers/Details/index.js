import { Component, PureComponent } from "react";

import React from 'react';
import {Text, View, StyleSheet} from 'react-native';


class DetailView extends Component {
    constructor(props) {
        super(props);
        this.state = {
            name: 'DetailPage'
        }
    }

    render() {
        return (
            <View style={{ flex: 1, justifyContent: "center", alignItems: "center" }}>
            <Text>Detail Screen {this.state.name}</Text>
            </View>
        )
    }
}

export default DetailView