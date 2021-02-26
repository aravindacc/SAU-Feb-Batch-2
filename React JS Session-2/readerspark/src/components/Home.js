import React, { useEffect, useState } from "react";
import Search from "react-search";
import Book from "./Books";
//import { Route, Switch } from "react-router-dom";
import Details from "./Searchresult";
import { BrowserRouter as Router, Switch, Route, Link } from "react-router-dom";

const apiurl =
  "https://api.nytimes.com/svc/books/v3/lists/current/hardcover-fiction.json?api-key=gxwan4uJ6f7SaoGwu93dKiFfqDFNgSiE";

function App() {
  const [books, setBooks] = useState([]);
  const [input, setInput] = useState([]);
  const [search, setSearch] = useState(null);

  useEffect(() => {
    fetch(apiurl)
      .then((res) => res.json())
      .then((data) => {
        console.log(data.results.books[0]);
        //console.log("type of data = " + typeof(data.results.books));

        // call function to extract books
        setBooks(data.results.books);
      });
  }, []);

  // const fetchbook = (data) => {

  // }

  const handleInput = (e) => {
    console.log(e.target.value);
    setInput(e.target.value);
  };

  const handleOnSubmit = (e) => {
    e.preventDefault();
    console.log(books);
    const [searchresult] = books.filter((book) => book.title === input);
    if (!searchresult) {
      alert("Unable to find the book " + input.toLowerCase());
    }
    setSearch(searchresult);
    console.log(searchresult);
    //console.log("Submit result " + books[input]);
  };

  if (search) {
    return <Details searchres={search} />;
  }
  return (
    <div className="book">
      <h1 className="font-bold text-center text-4xl py-10">
        {" "}
        Accolite's Reader's Park{" "}
      </h1>
      <header>
        <form onSubmit={handleOnSubmit}>
          <input
            className="searchbox"
            type="search"
            placeholder="search"
            onChange={handleInput}
          />
        </form>
        {/* <Search items = {books} /> */}
      </header>
      <div style={{ marginLeft: 50 }}>
        <section className="grid grid-cols-1 gap-10 px-5 sm:grid-cols-3 my-7 mx-20">
          {books.map((book) => {
            const {
              title,
              rank,
              description,
              author,
              book_image,
              amazon_product_url,
              publisher,
            } = book;
            console.log(title);
            return (
              <div className="bookcard">
                <article key={rank}>
                  <div className="card">
                    <Link
                      to={{
                        pathname: "/book",
                        state: {
                          title,
                          rank,
                          description,
                          author,
                          book_image,
                          amazon_product_url,
                          publisher,
                        },
                      }}
                    >
                      {" "}
                      <img src={book_image} alt={title} className="card" />{" "}
                    </Link>
                  </div>

                  <div className="bookinfo">
                    <h3>{title}</h3>
                  </div>
                </article>
              </div>
            );
          })}
        </section>
      </div>
      {/* doing {...book} gives us all the props*/}
      {/* {books.length > 0 && books.map((book) => <Book key = {book.primary_isbn10} {...book}/>)};
        this.props.history.push("/details", {details: item});

        https://www.youtube.com/watch?v=sLobT_UKKdw
        this.props.location.state
        .details

        exact sytax
        <Switch>
          <Route path = '/details' component = {Details} />
        </Switch> */}
    </div>
  );
}

export default App;
