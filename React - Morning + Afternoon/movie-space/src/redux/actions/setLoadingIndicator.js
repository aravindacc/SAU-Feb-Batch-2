import { SET_LOADING_INDICATOR } from './actionTypes';

export const setLoadingIndicator = (isLoading) => {
    return {
        type: SET_LOADING_INDICATOR,
        isLoading: isLoading
    }
}