import React from 'react';
import './App.css';
import { ToastContainer } from 'react-toastify';
import 'react-toastify/dist/ReactToastify.min.css';
import Header from './components/Header.jsx';

function App() {
  return (
    <div className='w-100 h-100'>
      <Header />
      <ToastContainer />
    </div>
  );
}

export default App;
