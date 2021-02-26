import React, { Component } from 'react';
import { setLoadingIndicator, setErrorIndicator } from '../../redux/actions/actionsExporter';
import { connect } from 'react-redux';
import { getBooksList } from '../../redux/services/servicesExport';
import './Books.css';
import SearchComponent from '../SearchBar/SearchComponent';
import BookCardComponent from '../BookCard/BookCardComponent';
import MySpinner from '../Spinner/MySpinner';

class AllBooksContainer extends Component {
    componentDidMount() {
        if (Object.keys(this.props.booksList).length === 0) {
            this.props.getBooksList();
        }
    }

    routeChange = (ISBN) => {
        let path = `/book-details/` + ISBN;
        this.props.history.push(path);
    }

    render() {
        const booksList = this.props.searchList.map((element) => {
            return (
                <BookCardComponent key={element.ISBN} element={element} />
            )
        });

        return (
            <div>
                {this.props.isLoading ? (
                    <MySpinner />
                ) : <div>
                        <SearchComponent />
                        <div className="flexing">
                            {booksList}
                        </div>
                    </div>}
            </div>
        );
    }
}

// Maps state of redux store as props in the component
const mapStateToProps = (state) => {
    return {
        booksList: state.booksList,
        searchList: state.searchList,
        isLoading: state.isLoading,
        error: state.error
    }
}

// Map Dispatch Action Creator To A prop in the component so that we can use it as event handler 
const mapDispatchToProps = (dispatch) => {
    return {
        getBooksList: () => dispatch(getBooksList()),
        setLoadingIndicator: (isLoading) => dispatch(setLoadingIndicator(isLoading)),
        setErrorIndicator: (error) => dispatch(setErrorIndicator(error)),
    }
}

export default connect(mapStateToProps, mapDispatchToProps)(AllBooksContainer);