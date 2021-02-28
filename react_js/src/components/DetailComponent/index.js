import React from "react";

export class BookComponent extends React.Component {
    constructor(props) {
        super(props);
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
        return (
            <div style={detail_layout}>
                <div style={img}>
                    <img style={{height: 400, width: 300}} src={this.props.location.state.thumbnailUrl}></img>
                </div>
                <div>
                    <h1>{this.props.location.state.title}</h1>
                    <h4><b>Authors: </b> {this.props.location.state.authors} </h4>
                    <h5><b>Categories: </b> {this.props.location.state.categories} </h5>
                    <h6><b>Published Date: </b>{this.props.location.state.publishedDate.$date}</h6>
                    <p><b>Description: </b>{this.props.location.state.shortDescription}</p>
                </div>
            </div>
        )
    }
}