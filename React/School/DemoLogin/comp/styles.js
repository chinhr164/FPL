import { StyleSheet } from "react-native"

const styles = StyleSheet.create({
    red: {
        color: 'red'
    },
    formGr: {
        padding: 16,
        margin: 16,
        backgroundColor: 'rgb(225,255,255)',
    },
    formCtrl: {
        marginVertical: 8,
        padding: 5,
        backgroundColor: 'rgb(255,255,255)',
        borderWidth: 1,
        borderColor: '#ccc',
        borderRadius: 3,
    },
    FAB1: {
        flex: 1,
        position: 'absolute',
        bottom: 8,
        left: '32%'
    },
    FAB2: {
        marginTop: 8
    }
})

export default styles