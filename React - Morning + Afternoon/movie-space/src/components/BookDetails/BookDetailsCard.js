import React, { Component } from 'react';

class BookDetailsCard extends Component {

    render() {
        console.log(this.props.bookDetails);
        const bookDetails = this.props.bookDetails;

        return (
            <div className="content">
                <div id="first-half" className="half">
                    <h1 className="title">{bookDetails.title}</h1>
                    <br></br>
                    <div className="no-change">
                        <div id="first-half1" className="half">
                            <img style={{ width: 300 }} alt="Back Cover" src="https://self-publishingschool.com/wp-content/uploads/2019/04/parts-of-a-book-back-cover.jpg" />
                        </div>
                        <div id="second-half2" className="half">
                            <h4 className="red" style={{ fontSize: 25 }}>Summary</h4>
                            <hr></hr>
                            <p style={{ fontSize: 20 }}>{bookDetails.summary}</p>
                        </div>
                    </div>
                </div>
                <div id="second-half" className="half">
                    <div className="book-cover">
                        <img src={bookDetails.image} alt="Book Cover" />
                    </div>
                    <h3>Click to order your book</h3>
                    <h4><b>Author:</b> &nbsp;<i>{bookDetails.author}</i></h4>
                    <h4><b>ISBN (optional):</b> &nbsp;<i>{bookDetails.ISBN}</i></h4>
                    {bookDetails.price ? (
                        <div>
                            <h4><b>Retail Price: &nbsp;&euro;</b> <i>{bookDetails.price.displayValue}</i></h4>
                            <h4><b>eBook Price: &nbsp;&euro;</b> <i>{bookDetails.price.displayValue}</i></h4>
                        </div>
                    )
                        :
                        (<div></div>)
                    }
                    <h4><b>Books Sold:</b> &nbsp;<i>200</i></h4>
                    <h4><b>eBooks Sold:</b> &nbsp;<i>100</i></h4>
                </div>
            </div>
        );
    }
}

export default BookDetailsCard;