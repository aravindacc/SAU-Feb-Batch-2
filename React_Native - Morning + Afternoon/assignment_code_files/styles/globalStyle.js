import { StyleSheet } from 'react-native';
import { Colors } from '../colors/Colors';


export const globalStyle = StyleSheet.create({
    container: {
        flex: 1,
        justifyContent: 'center',
        alignItems: 'center',
        backgroundColor: Colors.bgPrimary
    },
    results: {
        flex: 1,
    },
    result: {
        flex: 1,
        width: '100%',
        marginBottom: 50
    },
    heading: {
        color: 'white',
        fontSize: 20,
        fontWeight: '700',
        padding: 20,
        backgroundColor: Colors.titleSecondary,
        marginLeft: 20,
        marginRight: 20,
        textAlign: 'center'
    },
    body: {
        backgroundColor: Colors.bgNight
    },
    topview: {
        fontSize: 30,
        alignContent: 'center',
        padding: 10,
        textAlign: 'center',
        backgroundColor: '#223343',
        color: 'white',
        marginBottom: 20,
        shadowColor: "#348781"
    },
    detail: {
        margin:30,
        alignSelf:'center',
        textAlign:'center',
       
    }
});

