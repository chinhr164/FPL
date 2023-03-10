import { View, Text, TextInput } from 'react-native'
import React, { useState } from 'react'
import styles from './styles';
import { FAB } from 'react-native-elements';
import AsyncStorage from '@react-native-async-storage/async-storage';

const LoginComp = (props) => {
    const [username, setUsername] = useState('');
    const [passW, setPassW] = useState('');
    const [account, setAccount] = useState("")

    const getLogin = async () => {
        try {
            const jsonValue = await AsyncStorage.getItem('LoginK')
            if (jsonValue != null) {
                setAccount(JSON.parse(jsonValue));
                setUsername(account.username);
                setPassW(account.passW);
            }
            return
        } catch (e) {
            // error reading value
        }
    }


    const DoLogin = () => {
        if (username.length == 0) {
            alert('Vui lòng nhập Username'); return;
        }
        if (passW.length == 0) {
            alert('Vui lòng nhập Passwword'); return;
        }
        //link api check login
        let url_check_login = 'http://192.168.4.101:3000/user?username=' + username;
        fetch(url_check_login)
            .then((res) => { return res.json() })
            .then(async (arr_user) => {
                if (arr_user.length != 1) {
                    alert('Không tồn tại Username'); return;
                }
                let objU = arr_user[0];
                if (objU.passw != passW) {
                    console.log(objU);
                    alert('Sai password');
                    return;
                }

                try {
                    await AsyncStorage.setItem('LoginK', JSON.stringify(objU));
                    props.navigation.navigate('Home');
                } catch (e) {
                    // saving error
                    console.log('-------------');
                    console.log(e);
                    console.log('-------------');
                }

            })
    }

    return (
        <View style={styles.formGr}>
            <Text>Username<Text style={styles.red}> *</Text></Text>
            <TextInput style={styles.formCtrl} onChangeText={(txt) => { setUsername(txt) }} />
            <Text>Password<Text style={styles.red}> *</Text></Text>
            <TextInput style={styles.formCtrl} onChangeText={(txt) => { setPassW(txt) }} />
            <FAB style={styles.FAB2} title='Đăng nhập' onPress={DoLogin} />
        </View>
    )
}

export default LoginComp