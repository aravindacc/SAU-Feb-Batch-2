/**
 * Sample React Native App
 * https://github.com/facebook/react-native
 *
 * @format
 * @flow strict-local
 */
import 'react-native-gesture-handler';
import * as React from 'react';
import { NavigationContainer } from '@react-navigation/native';
import {createMaterialBottomTabNavigator} from '@react-navigation/material-bottom-tabs';
import TopRated from './screens/TopRated';
import Popular from './screens/Popular';
import UpComing from './screens/UpComing';
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

const Tab = createMaterialBottomTabNavigator();
//const App = () => 
export default function App() {
  return (
    <NavigationContainer>
      {<StatusBar
        barStyle="dark-content"
        hidden={false}
        backgroundColor="#00BCD4"
        translucent={true}
      /> }
      <Tab.Navigator
        tabBarOptions={{
        initalRouteName: 'Popular',
          labelStyle: {
            textTransform: 'none',
            fontWeight: 'bold',
            fontSize: 15,
            marginBottom: 10,
            color:'black'
          }
        }}>
        <Tab.Screen name="TopRated"  component={TopRated}/>
        <Tab.Screen name="UpComing" component={UpComing}/>
        <Tab.Screen name="Popular" component={Popular}/>
      </Tab.Navigator>
    </NavigationContainer>
    // <>
    //   <StatusBar barStyle="dark-content" backgroundColor="#00aaff" />
    //   <Text>Hello sush!!!!</Text>
      
    // </>
  );
};
const styles=StyleSheet.create({
  
})
