import React from "react";

const Books = (props) => {
    console.log("Inside books  " + props.location.state.title);
    const {
        title,
        rank,
        description,
        author,
        book_image,
        amazon_product_url,
        publisher,
    } = props.location.state;
    return (
        <div>
            <div>
                <h1 style = {{fontWeight:'bold', fontSize:40, textAlign:'center'}}> Details of the book </h1>
            </div>
            <div className="imgDetail">
                <img src={book_image} alt={title} height = "300px" width="200px" />
            </div>
            <div className= "contentDetail">
                <h1> Title : {title} </h1>
                <h1> Description: {description} </h1>
                <h1> Author: {author} </h1>
                <h1> Publisher: {publisher}</h1>
            </div>
            <div className = "buybutton" >
                <button>
                    <a href={amazon_product_url}> Click here to buy now </a>{" "}
                </button>
            </div>
        </div>
    );
};
export default Books;
