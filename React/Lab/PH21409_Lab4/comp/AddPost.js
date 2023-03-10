import { View, Text, TextInput } from 'react-native'
import React, { useState } from 'react'
import { CheckBox, FAB } from 'react-native-elements'
import styles from './style'

const AddPost = (props) => {
  const [title, setTitle] = useState('');
  const [author, setAuthor] = useState('');
  const [content, setContent] = useState('');
  const [image, setImage] = useState('');
  const [status, setStatus] = useState('');

  const SavePost = () => {
    let objPost = { title: title, author: author, content: content, image: image, status: status }
    let url_api = "https://63db697cc45e08a04344838f.mockapi.io/post";

    fetch(url_api, {
      method: 'POST',
      headers: {
        Accept: 'application/json',
        'Content-Type': 'application/json',
      },
      body: JSON.stringify(objPost),
    })
    .then((res)=>{
      if(res.status == 201){
        alert('Thêm bài viết thành công!');
        props.navigation.navigate('ListPost');
      }
        
    })
    .catch((ex) => {
      alert('Lỗi thêm bài viết ~');
    });
  }

  return (
    <View style={styles.formGr}>
      <Text>Tiêu đề<Text style={styles.red}> *</Text></Text>
      <TextInput style={styles.formCtrl} onChangeText={(txt) => { setTitle(txt) }} />
      <Text>Tác giả<Text style={styles.red}> *</Text></Text>
      <TextInput style={styles.formCtrl} onChangeText={(txt) => { setAuthor(txt) }} />
      <Text>Nội dung<Text style={styles.red}> *</Text></Text>
      <TextInput multiline={true} numberOfLines={5} style={styles.formCtrl} onChangeText={(txt) => { setContent(txt) }} />
      <Text>Link ảnh</Text>
      <TextInput style={styles.formCtrl} onChangeText={(txt) => { setImage(txt) }} />
      <Text>Trạng thái</Text>
      <TextInput style={styles.formCtrl} onChangeText={(txt) => { setStatus(txt) }} />
      <FAB style={styles.FAB2} title='Thêm bài viết' onPress={SavePost} />
    </View>
  )
}

export default AddPost