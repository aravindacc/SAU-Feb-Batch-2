import { createStore, applyMiddleware, compose } from 'redux';
import bookStoreManager from '../reducers/bookStoreManager';
import { persistStore, persistReducer } from 'redux-persist'
import thunk from "redux-thunk"
import storageSession from 'redux-persist/lib/storage/session'
// import storage from 'redux-persist/lib/storage' --> defaults to localStorage for web

const persistConfig = {
    key: 'root',
    storage: storageSession,
}

const persistedReducer = persistReducer(persistConfig, bookStoreManager)
const composeEnhancers = window.__REDUX_DEVTOOLS_EXTENSION_COMPOSE__ || compose;
const bookStore = createStore(persistedReducer, composeEnhancers(
    applyMiddleware(thunk)
));
const persistor = persistStore(bookStore);

export { bookStore, persistor };




