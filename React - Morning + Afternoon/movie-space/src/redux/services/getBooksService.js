import axios from 'axios';
import config from '../../components/requestConfig/getBooksConfig';
import { getAllBooks, setErrorIndicator, setLoadingIndicator } from '../../redux/actions/actionsExporter';

export const getBooksList = () => {
    return (dispatch) => {
        dispatch(setLoadingIndicator(true));
        return axios(config)
            .then(function (response) {
                dispatch(getAllBooks(response.data))
                dispatch(setLoadingIndicator(false))
            })
            .catch(function (error) {
                dispatch(getAllBooks({}))
                dispatch(setErrorIndicator(true))
                dispatch(setLoadingIndicator(false))
            });
    }
}