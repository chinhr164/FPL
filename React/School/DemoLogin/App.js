import { View, Text } from 'react-native'
import React from 'react'
import { NavigationContainer } from '@react-navigation/native';
import { createNativeStackNavigator } from '@react-navigation/native-stack';
import LoginComp from './comp/LoginComp';
import HomeComp from './comp/HomeComp';

const StackDemo = createNativeStackNavigator();

const App = () => {
  return (
    <NavigationContainer>
          <StackDemo.Navigator  initialRouteName='Login'>
            <StackDemo.Screen name='Login' component={LoginComp} options={ {title:'Đăng nhập'}} />
            <StackDemo.Screen name='Home' component={HomeComp} options={ {title:'Trang chủ'}} />
          </StackDemo.Navigator>
      </NavigationContainer>

  );
}

export default App