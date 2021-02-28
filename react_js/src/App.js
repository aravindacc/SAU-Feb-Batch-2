import logo from './logo.svg';
import './App.css';
import React from "react";
import Navigation from './utils/routes'

function App() {
  //console.log(books_data)

  return (
    <React.StrictMode>
      <Navigation />
    </React.StrictMode>
  );
}

export default App;
