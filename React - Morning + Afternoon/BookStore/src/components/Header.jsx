import React, { useState } from 'react';
import {
  InputGroup,
  Input,
  InputGroupAddon,
  Button,
  Spinner
} from 'reactstrap';
import 'react-toastify/dist/ReactToastify.min.css';
import toast from 'react-toastify';
import axios from 'axios';
import BookCard from './BookCard.jsx';
import './Header.css';

function Header()
{
  const [query, setQuery] = useState('');
  const [loading, setLoading] = useState(false);
  const [cards, setCards] = useState([]);
  // Handle Search
  const handleSubmit = () => 
  {
    setLoading(true);
      axios
        .get(
          `https://www.googleapis.com/books/v1/volumes?q=${query}`
        )
        .then(res => {
            if (res.data.items.length > 0) {
              setCards(res.data.items);
              setLoading(false);
            }
        })
         .catch(err => {
           setLoading(true);
           console.log(err.response);
        });
  };
  // Main Show Case
  const mainHeader = () => {
    return (
      <div className='main-image d-flex justify-content-center align-items-center flex-column'>
        {/* Overlay */}
        <div className='filter'></div>
        <h1
          className='display-2 text-center text-white mb-3'
          style={{ zIndex: 2 }}
        >
          <b>Books Store</b>
        </h1>
        <div style={{ width: '60%', zIndex: 2 }}>
          <InputGroup size='lg' className='mb-3'>
            <Input
              placeholder='Book Search'
              value={query}
              onChange={e => setQuery(e.target.value)}
            />
            <InputGroupAddon addonType='append'>
              <Button color='secondary' onClick={handleSubmit}>
                <i className='fas fa-search'></i>
              </Button>
            </InputGroupAddon>
          </InputGroup>
        </div>
      </div>
    );
  };

  const handleCards = () => {
    if (loading) {
      return (
        <div className='d-flex justify-content-center mt-3'>
          <Spinner style={{ width: '3rem', height: '3rem' }} />
        </div>
      );
    } else {
      const items = cards.map((item, i) => {
        let thumbnail = '';
        if (item.volumeInfo.imageLinks) {
          thumbnail = item.volumeInfo.imageLinks.thumbnail;
        }

        return (
          <div className='col-lg-4 mb-3' key={item.id}>
            <BookCard
              thumbnail={thumbnail}
              title={item.volumeInfo.title}
              pageCount={item.volumeInfo.pageCount}
              language={item.volumeInfo.language}
              authors={item.volumeInfo.authors}
              publisher={item.volumeInfo.publisher}
              description={item.volumeInfo.description}
              previewLink={item.volumeInfo.previewLink}
              infoLink={item.volumeInfo.infoLink}
            />
          </div>
        );
      });
      return (
        <div className='container my-5' /*style={{backgroundColor:'	#DCDCDC'}}*/>
          <div className='row'>{items}</div>
        </div>
      );
    }
  };
return(
  <>
  {mainHeader()}
  {handleCards()}
  </>
);
}
export default Header;
