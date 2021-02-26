import { GET_SEARCHED_BOOKS } from './actionTypes';

export const getSearchedBooks = (query) => {
    return {
        type: GET_SEARCHED_BOOKS,
        query: query,
        description: 'Getting Searched Books for the Main Books Page'
    }
}