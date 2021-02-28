import { Component, PureComponent } from "react";

import React from 'react';
import {Button, SafeAreaView, Text, View, Image, StyleSheet} from 'react-native';
import Carousel from 'react-native-snap-carousel';


class CarouselView extends Component {
    constructor(props) {
        super(props);
        this.state = {
            name: 'Carousel',
            entries: [
                {
                    title: "Item 1"
                },
                {
                    title: "Item 2"
                },
                {
                    title: "Item 3"
                },
                {
                    title: "Item 4"
                }
            ]
        }
    }

    _render_item({item, index}) {
        return (
            <View style={styles.container}>
                <Text>Some random text</Text>
                <Image source={require('../../assets/spongebob.png')}></Image>
            </View>
        )
    }

    render() {
        return (
            <Carousel 
                ref = {ref => this.carousel = ref}
                data = {this.state.entries}
                sliderWidth = {250}
                itemWidth = {250}
                renderItem = {this._render_item}
            />
        );
        // return (
        //     <View style={{ flex: 1, justifyContent: "center", alignItems: "center" }}>
        //     <Text>Home Screen {this.state.name}</Text>
        //     </View>
        // )
    }
}

export default CarouselView;

const styles = StyleSheet.create({
    container: {
        backgroundColor: '#3551c9',
        justifyContent: "center",
        alignItems: "center",
        height: 500,
    }
})