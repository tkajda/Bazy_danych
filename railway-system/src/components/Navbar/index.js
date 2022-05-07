import React from 'react';
import {
  Nav,
  NavLink,
  Bars,
  NavMenu,
  NavBtn,
  NavBtnLink
} from './NavbarElements';

const Navbar = () => {
  return (
    <>
      <Nav>
        <NavLink to='/'>
          LOGO
        </NavLink>
        <Bars />
        <NavMenu>
          <NavLink to='/tickets' activeStyle>BUY TICKETS</NavLink>
          <NavLink to='/history' activeStyle>TICKETS HISTORY</NavLink>
          <NavLink to='/add-route' activeStyle>ADD ROUTE</NavLink>
          <NavLink to='/list' activeStyle>LIST</NavLink>
          <NavLink to='/sign-up' activeStyle>SIGN UP</NavLink>
        </NavMenu>
        <NavBtn>
          <NavBtnLink to='/sign-in'>Sign In</NavBtnLink>
        </NavBtn>
      </Nav>
    </>
  );
};

export default Navbar;