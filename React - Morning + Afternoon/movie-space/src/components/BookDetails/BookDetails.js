import React, { Component } from 'react';
import { getBookDetails, setLoadingIndicator, setErrorIndicator } from '../../redux/actions/actionsExporter';
import { connect } from 'react-redux';
import MySpinner from '../Spinner/MySpinner';
import BookDetailsCard from './BookDetailsCard';
import './BookDetails.css';

class BookDetails extends Component {
    constructor(props) {
        super(props);
        this.state = {
            ISBN: window.location.pathname.split("/")[2]
        }
    }

    componentDidMount() {
        this.props.setLoadingIndicator(true);
        this.props.getBookDetails(this.state.ISBN);
    }

    render() {
        return (
            <div>
                {
                    this.props.isLoading ?
                        (
                            <MySpinner />
                        ) : (
                            <BookDetailsCard bookDetails={this.props.bookDetails} />
                        )
                }
            </div>
        );
    }
}

// Maps state of redux store as props in the component
const mapStateToProps = (state) => {
    return {
        bookDetails: state.bookDetails,
        isLoading: state.isLoading,
        error: state.error
    }
}

// Map Dispatch Action Creator To A prop in the component so that we can use it as event handler
const mapDispatchToProps = (dispatch) => {
    return {
        getBookDetails: (ISBN) => dispatch(getBookDetails(ISBN)),
        setLoadingIndicator: (isLoading) => dispatch(setLoadingIndicator(isLoading)),
        setErrorIndicator: (error) => dispatch(setErrorIndicator(error)),
    }
}

export default connect(mapStateToProps, mapDispatchToProps)(BookDetails);