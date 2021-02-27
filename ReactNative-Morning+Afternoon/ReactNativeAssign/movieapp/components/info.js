import React from 'react'
import { Text, View, TouchableOpacity} from 'react-native';
//import {Table,TableWrapper,Row,Rows,Col,Cell} from 'react-native-table-component';
const baseuri = "https://image.tmdb.org/t/p/w185_and_h278_bestv2";
 const Info = (props) => 
 {
     return (
        <View style={{flex: 1,
            justifyContent: 'center',
            backgroundColor: '#9fc6bd'}}>

            <Text style={{ fontSize: 18}}>
                <Text style={{ fontSize: 20, fontWeight: 'bold',color:'black' }}>
                    Title : </Text>
                {props.clickeddata.title}
            </Text>

            <Text style={{ fontSize: 18}}>
                <Text style={{ fontSize: 20, fontWeight: 'bold',color:'black' }}>
                    Released On : </Text>
                {props.clickeddata.release_date}
            </Text>

            <Text style={{ fontSize: 18}}>
                <Text style={{ fontSize: 20, fontWeight: 'bold',color:'black'  }}>
                    Rating : </Text>
                {props.clickeddata.vote_average}
            </Text>

            <Text style={{ fontSize: 18}}>
                <Text style={{ fontSize: 20, fontWeight: 'bold',color:'black' }}>
                    Movie Description : </Text>
                {props.clickeddata.overview}
            </Text>

            <TouchableOpacity
                style={{
                    backgroundColor: "#b3b3b3",
                    paddingVertical: 12,
                    paddingHorizontal: 32,
                    alignSelf: 'center',
                    marginTop: 30,
                    color: '#FFF'
                }}
                onPress={props.changeclicked}>
                <Text style = {{color:'black', fontSize:20}}>Back</Text>
            </TouchableOpacity>
        </View>
     )
}
export default Info;