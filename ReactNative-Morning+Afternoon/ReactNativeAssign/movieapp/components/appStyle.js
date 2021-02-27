import { StyleSheet } from 'react-native';

export const appStyle = StyleSheet.create({
    container: 
    {
        flex: 1,
        justifyContent: 'center',
        alignItems: 'center'
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
        color: 'black',
        fontSize: 20,
        fontWeight: '600',
        padding: 15,
        backgroundColor: '#999999',
        marginLeft: 20,
        marginRight: 20,
        textAlign: 'center'
    }
});