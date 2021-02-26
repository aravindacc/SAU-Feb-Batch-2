import React, { Component } from 'react';

class BookCardComponent extends Component {

    render() {
        const element = this.props.element;
        return (
            <section id="main" key={element.ISBN}>
                <div className="card">
                    <img className="image cover" alt="Book Cover" src={element.image} />
                    <div className="book-info">
                        <div className="title">{element.title}</div>
                        <div className="byline">by {element.author}</div>
                        <br></br>
                        <div className="about">
                            <p>{element.summary.substring(0, 50)} ...</p>
                        </div>
                    </div>
                    <div className="likes"><a href={"/book-details/" + element.ISBN}><span className="name">See Details</span>&nbsp;for this book</a></div>
                </div>
            </section>
        );
    }
}

export default BookCardComponent;