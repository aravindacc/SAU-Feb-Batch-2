import { GET_ALL_BOOKS } from './actionTypes';

export const getAllBooks = (response) => {
    return {
        type: GET_ALL_BOOKS,
        response: response,
        description: 'Getting All Books for the Main Books Page'
    }
}