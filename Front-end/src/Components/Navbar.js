import Nav from "react-bootstrap/Nav";
import Navbar from "react-bootstrap/Navbar";
import { NavLink } from "react-router-dom";

export default function NavbarMain() {
  let activeStyle = {
    color: "#E5EBEA",
    padding: "0.2rem",
    textDecoration: "none",
    borderBottom: "0.1rem solid #f2a30b",
    transition: "0.5s",
  };

  let commonStyle = {
    color: "#6c757d",
    textDecoration: "none",
    padding: "0.2rem",
  };

  return (
    <Navbar bg="dark" variant="dark" expand="md">
      <Navbar.Brand href="#home">
        <img
          src="https://upload.wikimedia.org/wikipedia/commons/thumb/c/c9/Naruto_logo.svg/1200px-Naruto_logo.svg.png?20130409052259"
          alt="Naruto Logo"
          width={"85"}
        />
      </Navbar.Brand>
      <Navbar.Toggle aria-controls="basic-navbar-nav" />
      <Navbar.Collapse id="basic-navbar-nav">
        <Nav className="ml-auto">
          <NavLink
            style={({ isActive }) => (isActive ? activeStyle : commonStyle)}
            to="/"
          >
            Home
          </NavLink>
          <NavLink
            style={({ isActive }) => (isActive ? activeStyle : commonStyle)}
            to="/episode"
          >
            Episode Guide
          </NavLink>
          <NavLink
            style={({ isActive }) => (isActive ? activeStyle : commonStyle)}
            to="/add"
          >
            Add
          </NavLink>
        </Nav>
      </Navbar.Collapse>
    </Navbar>
  );
}
