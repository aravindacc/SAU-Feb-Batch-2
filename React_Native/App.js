/**
 * Sample React Native App
 * https://github.com/facebook/react-native
 *
 * @format
 * @flow strict-local
 */

import React from 'react';
import {
  SafeAreaView,
  StyleSheet,
  ScrollView,
  View,
  Text,
  StatusBar,
} from 'react-native';

import {
  Header,
  LearnMoreLinks,
  Colors,
  DebugInstructions,
  ReloadInstructions,
} from 'react-native/Libraries/NewAppScreen';

import { NavigationContainer } from '@react-navigation/native';
import { createBottomTabNavigator } from '@react-navigation/bottom-tabs';
import HomeView from './app/containers/Home'
// import ProfileView from './app/containers/Profile'
// import DetailView from './app/containers/Details'
// import CarouselView from './app/components/carousel'
import UpComing from './app/containers/Upcoming'
import TopRated from './app/containers/TopRated'
import Popular from './app/containers/Popular'
import MaterialCommunityIcons from 'react-native-vector-icons/MaterialCommunityIcons';

const Tab = createBottomTabNavigator();

function MyTabs() {
  return (
    <Tab.Navigator 
      tabBarOptions={{
        activeBackgroundColor: '#121422',
        inactiveBackgroundColor: '#181b2d'
      }}
      >
      <Tab.Screen name="Upcoming" component={UpComing} options={{
        tabBarIcon: ({ color, size }) => (
          <MaterialCommunityIcons name="home" color={color} size={size} />
        ),
      }}/>
      <Tab.Screen name="TopRated" component={TopRated} options={{
        tabBarIcon: ({ color, size }) => (
          <MaterialCommunityIcons name="bell" color={color} size={size} />
        ),
      }}/>
      <Tab.Screen name="Popular" component={Popular} options={{
        tabBarIcon: ({ color, size }) => (
          <MaterialCommunityIcons name="account" color={color} size={size} />
        ),
      }}/>
    </Tab.Navigator>
  );
}

const App: () => React$Node = () => {
  return (
      <NavigationContainer>
        <MyTabs/>
      </NavigationContainer>
  );
};

export default App;
