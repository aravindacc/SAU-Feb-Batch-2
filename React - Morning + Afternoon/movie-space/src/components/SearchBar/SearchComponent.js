import React, { Component } from 'react';
import { Col, Form, Button, InputGroup, FormControl } from 'react-bootstrap';
import { getSearchedBooks } from '../../redux/actions/actionsExporter';
import { connect } from 'react-redux';

class SearchComponent extends Component {
    constructor(props) {
        super(props);
        this.state = {
            searchQuery: "",
            timer: 0
        }
    }

    updateSearch(searchQuery) {
        this.setState({
            timer: setTimeout(() => {
                console.log("stopped typing")
                this.props.getSearchedBooks(searchQuery.target.value);
            },
                2000),
            searchQuery: searchQuery.target.value
        })
    }

    render() {
        return (
            <Form style={{ marginLeft: "25%", paddingBottom: 50 }}>
                <Form.Row>
                    <Col>
                        <InputGroup size="lg" className="mb-3 searchBar">
                            <FormControl
                                placeholder="Search By Title"
                                aria-label="Search By Title"
                                aria-describedby="basic-addon1"
                                value={this.state.searchQuery}
                                onChange={(text) => { this.updateSearch(text) }}
                            />
                        </InputGroup>
                    </Col>
                    <Col>
                        <Button size="lg" variant="primary" className="btn">Filter</Button>
                    </Col>
                </Form.Row>
            </Form>
        );
    }
}

// Maps state of redux store as props in the component
const mapStateToProps = (state) => {
    return {
    }
}

// Map Dispatch Action Creator To A prop in the component so that we can use it as event handler 
const mapDispatchToProps = (dispatch) => {
    return {
        getSearchedBooks: (query) => dispatch(getSearchedBooks(query)),
    }
}

export default connect(mapStateToProps, mapDispatchToProps)(SearchComponent);