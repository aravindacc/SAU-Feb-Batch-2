import React from "react";
import { books_data } from '../../books.json'
import { Alert } from "react-bootstrap"
import 'bootstrap/dist/css/bootstrap.min.css'

export class SearchComponent extends React.Component {
    constructor(props) {
        super(props)
    }

    render() {
        const detail_layout = {
            columns: 3,
            marginTop: 30
        }

        const img = {
            display: "flex",
            justifyContent: "center",
            alignItems: "center",
        }

        var title = this.props.location.state.search;

        const [searchResult] = books_data.filter((book) => book.title.toLowerCase() === title.toLowerCase());
        console.log(searchResult);

        if (title === "" || !searchResult) {
            return (
                <Alert variant="danger" style={{marginTop: 50, marginLeft: 200, marginRight: 200}}>
                    <Alert.Heading>Oh snap! No Content Found!</Alert.Heading>
                    <p>
                    The Book you are looking for is not found. Please try again !!
                    </p>
                </Alert>
            )
        } else {
            return (
                <div style={detail_layout}>
                    <div style={img}>
                        <img style={{height: 400, width: 300}} src={searchResult.thumbnailUrl}></img>
                    </div>
                    <div>
                        <h1>{searchResult.title}</h1>
                        <h4><b>Authors: </b> {searchResult.authors} </h4>
                        <h5><b>Categories: </b> {searchResult.categories} </h5>
                        <h6><b>Published Date: </b>{searchResult.publishedDate.$date}</h6>
                        <p><b>Description: </b>{searchResult.shortDescription}</p>
                    </div>
                </div>
            )
        }
    }
}