import React from "react";
import { books_data } from '../../books.json'

export class HomeComponent extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            search: ''
        }

        this.handleChange = this.handleChange.bind(this);
    }

    handleChange(event) {
        this.setState({search: event.target.value})
    }

    render() {
        const books_layout = {
            columns: 3,
        }

        const container = {
            
        }

        const header = {
            display: "flex",
            justifyContent: "center",
            alignItems: "center",
            marginTop: 20,
        }

        var books = books_data;

        return (
            <div style={ container }>
                <header style={header}>
                    <form onSubmit={() => {this.props.history.push({
                        pathname: '/search',
                        state: this.state
                    })}}>
                        <input placeholder="Search for a Book" ref="searchString" onChange={this.handleChange}></input>
                        <input type="Submit" value="Search"></input>
                    </form>
                </header>
                <div style={ books_layout }>
                    { books.map((book) => {
                        const {
                            title,
                            isbn,
                            pageCount,
                            publishedDate,
                            thumbnailUrl,
                            shortDescription,
                            longDescription,
                            status,
                            authors,
                            categories
                        } = book;
                        console.log(title);
                        return (
                            <div>
                                <img src={thumbnailUrl} onClick={() => {this.props.history.push({
                                    pathname: '/book',
                                    state: book
                                })}} style={{ height: 200, width: 150}} />
                                <h3>{title}</h3>
                            </div>
                        )
                    }) }
                </div>
            </div>
        )
    }
}

export default HomeComponent;