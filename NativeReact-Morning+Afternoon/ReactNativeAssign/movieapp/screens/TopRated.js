import React, {Component} from 'react';
import {
  Text,
  View,
  StyleSheet,
  Image,
  TouchableOpacity,
  ScrollView,
} from 'react-native';
import {FlatList, ActivityIndicator} from 'react-native';
import Info from '../components/info';
import {appStyle} from '../components/appStyle';

class TopRated extends Component {
  constructor(props) {
    super(props);
    this.state = {
      data: [],
      clicked: false,
      clickeddata: null,
    };
  }

  baseuri = 'https://image.tmdb.org/t/p/w185_and_h278_bestv2';

  async getData() {
    const res = await fetch(
      'https://api.themoviedb.org/3/movie/top_rated?api_key=ed92469c644d7cb38f2454002993afc2&language=en-US&page=3',
    );
    const resJson = await res.json();
    this.setState({data: resJson.results});
  }

  componentDidMount() {
    this.getData();
  }

  showdetails(item) {
    console.log(item);
    this.setState({clicked: true});
    this.setState({clickeddata: item});
  }

  changeclicked() {
    this.setState({clicked: false});
    this.setState({clickeddata: null});
  }

  render() {
    if (this.state.clicked) {
      return (
        <Info
          changeclicked={this.changeclicked.bind(this)}
          clickeddata={this.state.clickeddata}
        />
      );
    }
    return (
      <View style={appStyle.body}>
        <Text style={appStyle.topview}> Top Rated Movies </Text>

        <ScrollView styles={appStyle.results}>
          {this.state.data.map((item) => (
            <TouchableOpacity onPress={() => this.showdetails(item)}>
              <View key={item.id} style={appStyle.result}>
                <Image
                  source={{uri: this.baseuri + item.poster_path}}
                  style={{
                    width: 300,
                    height: 300,
                    marginLeft: 50,
                    marginRight: 20,
                    marginBottom: 20,
                  }}
                  resizeMode="cover"
                />
                <Text style={appStyle.heading}> {item.title} </Text>
              </View>
            </TouchableOpacity>
          ))}
        </ScrollView>
      </View>
    );
  }
}
export default TopRated;