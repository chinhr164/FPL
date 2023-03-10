import { StyleSheet } from "react-native";
import { Overlay } from "react-native-elements/dist/overlay/Overlay";

const styles = StyleSheet.create({
    container: {
        flex: 1
    },
    item: {
        padding: 8,
        marginHorizontal: 16,
        marginVertical: 8,
        borderWidth: 2,
        borderColor: 'rgb(221,194,115)',
        backgroundColor: 'rgb(255,242,204)',
    },
    title: {
        fontWeight: '700',
        fontSize: 20
    },
    author: {
        fontSize: 16,
        marginVertical: 8
    },
    content: { fontSize: 16 },
    img: {
        marginVertical: 16,
        width: '70%',
        height: undefined,
        aspectRatio: 1,
    },
    status: {
        fontStyle: 'italic',
        justifyContent: 'flex-end',
        marginTop: 8
    },
    tools: {
        flexDirection: 'row'
    },
    imgEdit: {
        width: 30,
        height: 30,
        margin: 8
    },
    imgDel: {
        width: 30,
        height: 30,
        margin: 8
    },

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
});

export default styles;