import { Component, PureComponent } from "react";

import React from 'react';
import {Button, Text, View, StyleSheet, Image, TouchableOpacity, TouchableWithoutFeedback} from 'react-native';
import Carousel from 'react-native-snap-carousel';


class HomeView extends Component {
    constructor(props) {
        super(props);
        this.state = {
            name: 'Carousel',
            data: "Hello",
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

    // async getData() {
    //     const res = await fetch('https://api.themoviedb.org/3/movie/upcoming?api_key=4cfbaf275e7c796eded0b452dbc74644&language=en-US&page=1');
    //     const resJson = await res.json();
    //     this.setState({data: resJson.results});
    // }

    // componentDidMount() {
    //     this.getData();
    // }

    // showDetails(item) {
    //     console.log(item);
    // }

    _render_item({item, index}) {
        return (
            <Text onPress={() => console.log("Hello")}>Hello World</Text>
            // <View>
            //     <Text>Upcoming Movies</Text>
            //     {this.state.data.map((item) => (
            //         <TouchableWithoutFeedback onPress={() => this.showDetails(item)}>
            //         <View style={styles.data_in_carousel}> 
            //             <Image source={require('../../assets/sadpatrick.jpg')}></Image>
            //             <Text>Movie Name</Text>
            //         </View>
            //         </TouchableWithoutFeedback>
            //     ))}
            // </View>
        )
    }

    render() {
        return (
            <View style={styles.container}>
                <Carousel
                    layout = {'default'}
                    ref = {ref => this.carousel = ref}
                    data = {this.state.entries}
                    sliderWidth = {400}
                    itemWidth = {300}
                    renderItem = {this._render_item}
                />
            </View>
        );
        // return (
        //     <View style={{ flex: 1, justifyContent: "center", alignItems: "center" }}>
        //     <Text>Home Screen {this.state.name}</Text>
        //     </View>
        // )
    }
}

export default HomeView;

const styles = StyleSheet.create({
    data_in_carousel: {
        justifyContent: "center",
        alignItems: "center",
        height: 500,
        width: 250,
    },
    container: {
        justifyContent: "center",
        alignItems: "center",
        flex: 1,
        backgroundColor: '#3551c9'
    }
})