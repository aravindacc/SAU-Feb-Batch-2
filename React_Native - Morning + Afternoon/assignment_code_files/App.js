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

import Popular from './screens/Popular/Popular';
import TopRated from './screens/TopRated/TopRated';
import UpComing from './screens/Upcoming/UpComing';
import {createAppContainer} from 'react-navigation';
import {createMaterialBottomTabNavigator} from 'react-navigation-material-bottom-tabs';
import TabNavigator from './navigation/Navigation';

class App extends React.Component {
  render() {
    return (
      <View style = {{flex:1, justifyContent:'center', alignItems:'center'}}>
        <TabNavigator/>
      </View>
    );
  };
}

export default App