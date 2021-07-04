import { StyleSheet } from 'react-native';


export const customStyle = StyleSheet.create({
    container: {
        flex: 1,
        justifyContent: 'center',
        alignItems: 'center',
    },
    card: {
        flex: 1,
        width: '100%',
        marginBottom: 50,
        marginTop: 10
    },
    title: {
        color: 'white',
        fontSize: 18,
        fontWeight: '700',
        marginLeft: 20,
        paddingTop: 10,
        textAlign: 'left',
        flex: 1
    },

    detail: {
        margin:30,
        alignSelf:'center',
        textAlign:'center',
        flex: 2
       
    },
    rating: {
        color: 'yellow',
        fontSize: 20,
        textAlign: 'right',
        marginRight: 20,
        paddingTop: 10,
        flex: 1
    },
    detail_image: {
        marginTop: 20,
        marginLeft: 20,
        height: 300,
        width: 200,
        flex: 2
    },
    detail_text: {
        flex: 2,
        marginTop: 20,
        marginLeft: 10
    },
    detail_title: {
        fontSize: 35,
        fontWeight: 'bold',
        color: 'white',
    },
    detail_rating: {
        fontSize: 35,
        fontWeight: 'bold',
        color: 'yellow',
        marginTop: 10
    },
    detail_release_date: {
        fontSize: 25,
        color: 'white',
        marginTop: 10
    },
    detail_popularity_heading: {
        marginTop: 3,
        fontSize: 15,
        fontWeight: 'bold',
        color: 'yellow',
    },
    detail_popularity_value: {
        marginTop: 3,
        fontSize: 15,
        color: 'white'
    },
    overview: {
        fontSize: 20,
        color: 'white',
        marginTop: 20,
        textAlign: 'justify',
        marginLeft: 20,
        marginRight: 20,
        lineHeight: 30
    }
});