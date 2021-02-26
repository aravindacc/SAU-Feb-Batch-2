import { Provider } from 'react-redux';
import { bookStore } from './redux/stores/bookStore';
import { persistor } from './redux/stores/bookStore';
import NavBarComponent from './components/NavBar/NavBarComponent';
import AllBooksContainer from './components/AllBooks/AllBooksContainer';
import BookDetails from './components/BookDetails/BookDetails';
import { BrowserRouter, Route, Redirect } from 'react-router-dom';
import { PersistGate } from 'redux-persist/integration/react'

function App() {
  return (
    <BrowserRouter>
      <Provider store={bookStore}>
        <PersistGate loading={null} persistor={persistor}>
          <div className="App">
            <NavBarComponent />
            <Route exact path="/" render={() => {
              return (
                <Redirect to="/book-home" />
              )
            }}></Route>
            <Route path="/book-home" component={AllBooksContainer}></Route>
            <Route path="/book-details/:isbn" component={BookDetails}></Route>
          </div>
        </PersistGate>
      </Provider>
    </BrowserRouter >
  );
}

export default App;
