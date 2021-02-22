import React from 'react';
import {
  SafeAreaView,
  StyleSheet,
  ScrollView,
  View,
  Text,
  StatusBar,
} from 'react-native';


import { createAppContainer } from 'react-navigation';
import { createMaterialBottomTabNavigator } from 'react-navigation-material-bottom-tabs';
import Popular from '../screens/Popular/Popular'
import TopRated from '../screens/TopRated/TopRated'
import UpComing from '../screens/Upcoming/UpComing';
import {globalStyle} from '../../styles/globalStyle';
import { Colors } from '../../colors/Colors';




const TabNavigator = createMaterialBottomTabNavigator(
  {
    Popular: {
      screen: Popular,
    },
    TopRated: {
      screen: TopRated,
    },
    UpComing: {
      screen: UpComing
    },
  },
  {
    
    activeColor: '#f0edf6',
    initalRouteName: 'Popular',
    inactiveColor: '#E8A317',
    barStyle: { backgroundColor: Colors.bgSecondary, marginTop: 60},
  }
);


export default createAppContainer(TabNavigator);
