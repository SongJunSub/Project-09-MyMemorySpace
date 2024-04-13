import {Button, Container, Form, Nav, Navbar, NavDropdown} from "react-bootstrap";
import React from "react";
import {useNavigate} from "react-router-dom";

const TopContainer = () => {

    const navigate = useNavigate();

    const moveToGit = () => {
        const gitURL = "https://github.com/SongJunSub";

        window.open(gitURL, "_blank");
    }

    return (
        <div>
            <Navbar expand="lg" className="bg-body-tertiary">
                <Container fluid>
                    <Navbar.Brand href="/">Jun's Memory Space</Navbar.Brand>

                    <Navbar.Toggle aria-controls="navbarScroll"/>
                    <Navbar.Collapse id="navbarScroll">
                        <Nav className="me-auto my-2 my-lg-0" style={{ maxHeight: '100px' }} navbarScroll>
                            <Nav.Link href="#action1">소개</Nav.Link>
                            <Nav.Link onClick={() => moveToGit()}>Git</Nav.Link>
                            <NavDropdown title="Function" id="navbarScrollingDropdown">
                                <NavDropdown.Item>기능 소개</NavDropdown.Item>
                                <NavDropdown.Divider/>
                                <NavDropdown.Item onClick={() => {navigate("/api/reservation")}}>예약 생성 (JPA)</NavDropdown.Item>
                                <NavDropdown.Item onClick={() => {navigate("/api/jpaSelect")}}>예약 목록 (JPA)</NavDropdown.Item>
                                <NavDropdown.Item>예약 목록 (MyBatis)</NavDropdown.Item>
                            </NavDropdown>
                        </Nav>
                        <Form className="d-flex">
                            <Form.Control type="search" placeholder="Search" className="me-2" aria-label="Search"/>
                            <Button variant="outline-success">Search</Button>
                        </Form>
                        <Button className="signUp" variant="primary" type="submit">
                            Sign Up
                        </Button>
                        <Button variant="outline-success" type="submit">
                            Sign In
                        </Button>
                    </Navbar.Collapse>
                </Container>
            </Navbar>
        </div>
    );

}

export default TopContainer;