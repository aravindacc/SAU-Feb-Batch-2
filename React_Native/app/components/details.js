import React from 'react'
import { Button, Text, View, TouchableOpacity, Image, ScrollView, StyleSheet } from 'react-native';
import { customStyle } from '../styles/customStyle';

const baseuri = "https://image.tmdb.org/t/p/w185_and_h278_bestv2";


const Details = (props) => {
    return (
        <View style={{backgroundColor: '#181B2D'}}>
            <ScrollView>
            <View style={{flexDirection: 'row'}}>
                <Image source={{uri: baseuri + props.detailsData.backdrop_path}}
                    style={customStyle.detail_image}></Image>
                <View style={customStyle.detail_text}>
                    <Text style={customStyle.detail_title}>{props.detailsData.title}</Text>
                    <Text style={customStyle.detail_rating}>{props.detailsData.vote_average}</Text>
                    <View style={{flexDirection: 'row'}}>
                        <Text style={customStyle.detail_popularity_heading}>Popularity: </Text>
                        <Text style={customStyle.detail_popularity_value}>{props.detailsData.popularity}</Text>
                    </View>
                    <View style={{flexDirection: 'row'}}>
                        <Text style={customStyle.detail_popularity_heading}>Vote Count: </Text>
                        <Text style={customStyle.detail_popularity_value}>{props.detailsData.vote_count}</Text>
                    </View>
                    <Text style={customStyle.detail_release_date}>{props.detailsData.release_date}</Text>
                    <Text></Text>
                </View>
            </View>
            <Text style={customStyle.overview}>{props.detailsData.overview}</Text>
            <TouchableOpacity
                style={{
                    backgroundColor: "yellow",
                    paddingVertical: 10,
                    alignSelf: 'flex-start',
                    marginLeft: 20,
                    paddingHorizontal: 30,
                    borderRadius: 40,
                    marginTop: 30,
                    marginBottom: 20,
                }}
                onPress={props.returnToHomePage}
                >
                <Text style = {{color:'black', fontSize:20, fontWeight: 'bold'}}>Back</Text>
            </TouchableOpacity>
            </ScrollView>
        </View>
    )
}

export default Details