import React, { Component } from 'react';
import { Spinner } from 'react-bootstrap';

class MySpinner extends Component {
    render() {
        return (
            <div>
                <Spinner size="lg" style={{
                    position: 'fixed',
                    top: "50%",
                    left: "50%"
                }}
                    animation="border" variant="info" role="status">
                    <span className="sr-only">Loading...</span>
                </Spinner>
            </div>
        );
    }
}

export default MySpinner;