import { View, Text, TextInput } from 'react-native'
import React, { useState } from 'react'
import { CheckBox, FAB } from 'react-native-elements'
import styles from './style'

const UpdatePost = (props) => {
  const [title, setTitle] = useState(props.route.params.item.title);
  const [author, setAuthor] = useState(props.route.params.item.author);
  const [content, setContent] = useState(props.route.params.item.content);
  const [image, setImage] = useState(props.route.params.item.image);
  const [status, setStatus] = useState(props.route.params.item.status);

  const SavePost = () => {
    let _id = props.route.params.item.id;
    let objPost = { title: title, author: author, content: content, image: image, status: status }
    let url_api = "https://63db697cc45e08a04344838f.mockapi.io/post/" + _id;

    fetch(url_api, {
      method: 'PUT',
      headers: {
        Accept: 'application/json',
        'Content-Type': 'application/json',
      },
      body: JSON.stringify(objPost),
    })
      .then((res) => {
        if (res.status == 200) {
          alert('Sửa bài viết thành công!');
          props.navigation.navigate('ListPost');
        }

      })
      .catch((ex) => {
        alert('Lỗi sửa bài viết ~');
      });
  }

  return (
    <View style={styles.formGr}>
      <Text>Tiêu đề<Text style={styles.red}> *</Text></Text>
      <TextInput style={styles.formCtrl} onChangeText={(txt) => { setTitle(txt) }} value={title} />
      <Text>Tác giả<Text style={styles.red}> *</Text></Text>
      <TextInput style={styles.formCtrl} onChangeText={(txt) => { setAuthor(txt) }} value={author} />
      <Text>Nội dung<Text style={styles.red}> *</Text></Text>
      <TextInput multiline={true} numberOfLines={5} style={styles.formCtrl} onChangeText={(txt) => { setContent(txt) }} value={content} />
      <Text>Link ảnh</Text>
      <TextInput style={styles.formCtrl} onChangeText={(txt) => { setImage(txt) }} value={image} />
      <Text>Trạng thái</Text>
      <TextInput style={styles.formCtrl} onChangeText={(txt) => { setStatus(txt) }} value={status} />
      <FAB style={styles.FAB2} title='Sửa bài viết' onPress={SavePost} />
    </View>
  )
}

export default UpdatePost