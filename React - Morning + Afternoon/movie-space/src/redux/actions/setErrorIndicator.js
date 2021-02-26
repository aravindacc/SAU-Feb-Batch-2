import { SET_ERROR_INDICATOR } from './actionTypes';

export const setErrorIndicator = (error) => {
    return {
        type: SET_ERROR_INDICATOR,
        error: error
    }
}