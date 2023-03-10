import { View, Text, FlatList, ActivityIndicator, ScrollView, Image, TouchableHighlight } from "react-native";
import React, { useState } from "react";
import { FAB } from 'react-native-elements';
import styles from "./style";

const ListPost = (props) => {
  const [isLoading, setisLoading] = useState(true);
  const [listPost, setListPost] = useState([]);
  // viết hàm load SP
  const getList = async () => {
    let url_api = "https://63db697cc45e08a04344838f.mockapi.io/post";
    try {
      const response = await fetch(url_api);
      const json = await response.json();
      setListPost(json);

    } catch (error) {
      console.error(error);
    } finally {
      setisLoading(false);
    }
  }
  const renderPost = (row) => {
    const delPost = () => {
      let url_api_del = "https://63db697cc45e08a04344838f.mockapi.io/post/" + row.item.id;
      console.log(row.item.id);

      fetch(url_api_del, {
        method: 'DELETE',
        headers: {
          Accept: 'application/json',
          'Content-Type': 'application/json',
        }
      })
        .then((res) => {
          if (res.status == 200) {
            alert("Đã xóa bài viết!");
            getList();
          } else {
            alert("111")
          }

        })
        .catch((ex) => {
          alert("Lỗi xóa bài viết ~")
        });
    }
    return (
      <View style={styles.item}>
        <Text style={styles.title}>{row.item.title}</Text>
        <Text style={styles.author}> ~ {row.item.author}</Text>
        <Text style={styles.content}>{row.item.content} </Text>
        <Text>{row.item.image}</Text>
        {/* <Image style={styles.img} source={{ uri: row.item.image }} /> */}
        <Text style={styles.status}>{row.item.status}</Text>
        <View style={styles.tools}>
          <TouchableHighlight onPress={() => { props.navigation.navigate('UpdatePost', { item: row.item }) }}>
            <Image style={styles.imgEdit} source={require('../assets/edit.png')} />
          </TouchableHighlight>
          <TouchableHighlight onPress={delPost}>
            <Image style={styles.imgDel} source={require('../assets/delete.png')} />
          </TouchableHighlight>
        </View>
      </View>
    );
  }

  React.useEffect(() => {
    const unsubscribe = props.navigation.addListener('focus', () => {
      // do something
      getList();
    });

    return unsubscribe;
  }, [props.navigation]);


  return (
    <View style={styles.container}>
      <ScrollView>
        {
          (isLoading) ? (
            <ActivityIndicator />
          ) : (
            <FlatList data={listPost}
              keyExtractor={(item) => { return item.id; }}
              renderItem={renderPost} />
          )
        }
      </ScrollView>
      <FAB style={styles.FAB1} title='Thêm bài viết' onPress={() => { props.navigation.navigate('AddPost') }} />
    </View>
  );
}

export default ListPost;