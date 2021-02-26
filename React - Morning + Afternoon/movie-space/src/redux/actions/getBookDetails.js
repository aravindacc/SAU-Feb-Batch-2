import { GET_BOOK_DETAILS } from './actionTypes';

export const getBookDetails = (ISBN) => {
    return {
        type: GET_BOOK_DETAILS,
        ISBN: ISBN,
        description: 'Getting Specific Book Details for the Specific Book Page'
    }
}