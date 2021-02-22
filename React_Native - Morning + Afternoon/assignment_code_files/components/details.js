import React from 'react'
import { Text, View, TouchableOpacity, Image } from 'react-native';
import { globalStyle } from '../styles/globalStyle';

const baseuri = "https://image.tmdb.org/t/p/w185_and_h278_bestv2";


const Details = (props) => {
    // console.log("Inside details component")
    return (
        <View style={globalStyle.detail}>
            

            <Text style={{ fontSize: 20, fontFamily: 'Roboto', fontWeight: 'bold', color: '#2B3856' }}>
                <Text style={{ color: '#E55451', fontSize: 20, fontFamily: 'monospace', fontWeight: 'bold' }}>
                    Title : </Text>

                {props.clickeddata.title}
            </Text>

            <Text style={{ fontSize: 20, fontFamily: 'Roboto', fontWeight: 'bold', color: '#2B3856' }}>
                <Text style={{ color: '#E55451', fontSize: 20, fontFamily: 'monospace', fontWeight: 'bold' }}>
                    Released On : </Text>

                {props.clickeddata.release_date}
            </Text>

            <Text style={{ fontSize: 20, fontFamily: 'Roboto', fontWeight: 'bold', color: '#2B3856' }}>
                <Text style={{ color: '#E55451', fontSize: 20, fontFamily: 'monospace', fontWeight: 'bold' }}>
                    Rating : </Text>

                {props.clickeddata.vote_average}
            </Text>

            <Text style={{ fontSize: 20, fontFamily: 'Roboto', fontWeight: 'bold', color: '#2B3856' }}>
                <Text style={{ color: '#E55451', fontSize: 20, fontFamily: 'monospace', fontWeight: 'bold' }}>
                    Movie Description : </Text>

                {props.clickeddata.overview}
            </Text>

            <TouchableOpacity
                style={{
                    backgroundColor: "#728C00",
                    paddingVertical: 10,
                    paddingHorizontal: 30,
                    alignSelf: 'center',
                    borderRadius: 40,
                    marginTop: 30,
                    color: '#FFF'
                }}
                onPress={props.changeclicked}>
                <Text style = {{color:'white', fontSize:20}}>Back</Text>
            </TouchableOpacity>
        </View>
    )
}

export default Details


