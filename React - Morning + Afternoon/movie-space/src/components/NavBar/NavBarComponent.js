import { Navbar, Nav } from 'react-bootstrap';
import React from 'react';

function NavBarComponent(props) {
    return (
        <div>
            <Navbar bg="dark" expand="lg" variant="dark">
                <Navbar.Brand href="/book-home">
                    <img
                        src="https://i.pinimg.com/originals/bd/fd/66/bdfd668947413b49955e7ec2d8bef93f.jpg"
                        width="30"
                        height="30"
                        className="d-inline-block align-top"
                        alt="My Book Space"
                    />&nbsp;&nbsp;
                        <b>My Book Space</b></Navbar.Brand>
                <Navbar.Toggle aria-controls="basic-navbar-nav" />
                <Navbar.Collapse id="basic-navbar-nav">
                    <Nav className="mr-auto" activeKey={window.location.pathname}>
                        <Nav.Link href="/book-home" style={{ paddingLeft: 50, paddingRight: 50 }}><b>Books Home</b></Nav.Link>
                        <Nav.Link href="/book-details/:isbn"><b>Book Details</b></Nav.Link>
                    </Nav>
                </Navbar.Collapse>
            </Navbar>
        </div>
    );
}

export default NavBarComponent;