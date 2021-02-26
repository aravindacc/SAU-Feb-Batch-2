import { GET_ALL_BOOKS, GET_BOOK_DETAILS, GET_SEARCHED_BOOKS, SET_LOADING_INDICATOR, SET_ERROR_INDICATOR } from '../actions/actionTypes';
import { getUpdatedSearchList } from '../utils/getUpdatedSearchList';
import { getBookDetails } from '../utils/getBookDetails'

const initialState = {
    booksList: [],
    searchList: [],
    error: false,
    isLoading: true,
    bookDetails: {}
}

const bookStoreManager = (state = initialState, action) => {
    switch (action.type) {
        case GET_ALL_BOOKS:
            return {
                ...state,
                booksList: [...action.response],
                searchList: [...action.response]
            }
        case GET_SEARCHED_BOOKS:
            return {
                ...state,
                searchList: getUpdatedSearchList(state.booksList, action.query)
            }
        case GET_BOOK_DETAILS:
            return {
                ...state,
                isLoading: false,
                bookDetails: getBookDetails(state.booksList, action.ISBN)
            }
        case SET_LOADING_INDICATOR:
            return {
                ...state,
                isLoading: action.isLoading
            }
        case SET_ERROR_INDICATOR:
            return {
                ...state,
                error: action.error
            }
        default:
            return state;
    }
}

export default bookStoreManager;