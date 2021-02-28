import React, {Component} from 'react';
import { Text, View, Image, TouchableOpacity, ScrollView} from 'react-native';

import Details from '../../components/details';
import {customStyle} from '../../styles/customStyle';
import {API} from '../../api'

class TopRated extends Component {
  image_uri = API.IMAGE_URI;

  constructor(props) {
    super(props);
    this.state = {
      detailsData: null,
      data: [],
      isClicked: false
    };
  }

  returnToHomePage() {
    this.setState({isClicked: false});
    this.setState({detailsData: null});
  }

  async getData() {
    const res = await fetch(
      API.TOPRATED,
    );
    const resJson = await res.json();
    this.setState({data: resJson.results});
  }

  componentDidMount() {
    this.getData();
  }

  render() {
    if (!this.state.isClicked) {
      return (
        <View style={{backgroundColor: '#181B2D'}}>
          <ScrollView styles={{flex: 1}}>
            {this.state.data.map((item) => (
              <TouchableOpacity onPress={() => {
                this.setState({isClicked: true})
                this.setState({detailsData: item})
                }}>
                <View key={item.id} style={customStyle.card}>
                  <Image
                    source={{uri: this.image_uri + item.poster_path}}
                    style={{
                      height: 250,
                    }}
                  />
                  <View style={{flexDirection: 'row'}}>
                      <Text style={customStyle.title}> {item.title} </Text>
                      <Text style={customStyle.rating}> {item.vote_average} </Text>
                  </View>
                </View>
              </TouchableOpacity>
            ))}
          </ScrollView>
        </View>
      );
    } else {
      return (
        <Details
          returnToHomePage={this.returnToHomePage.bind(this)}
          detailsData={this.state.detailsData}
        />
      );
    }
  }
}

export default TopRated;