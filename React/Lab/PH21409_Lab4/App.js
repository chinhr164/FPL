import * as React from 'react';
import { NavigationContainer } from '@react-navigation/native';
import { createNativeStackNavigator } from '@react-navigation/native-stack';
import ListPost from './comp/ListPost';
import AddPost from './comp/AddPost';
import UpdatePost from './comp/UpdatePost';
const StackDemo = createNativeStackNavigator();

export default function App() {
  return (
    <NavigationContainer>
      <StackDemo.Navigator initialRouteName='ListPost'>
        <StackDemo.Screen name='ListPost' component={ListPost} options={{ title: 'Danh sách bài viết' }} />
        <StackDemo.Screen name='AddPost' component={AddPost} options={{ title: 'Thêm bài viết' }} />
        <StackDemo.Screen name='UpdatePost' component={UpdatePost} options={{ title: 'Sửa bài viết' }} />
      </StackDemo.Navigator>
    </NavigationContainer>
  );
}


