import React from 'react';
import logo from '../resources/LOGO.png'

import {
  Nav,
  NavLink,
  Bars,
  NavMenu,
  NavBtn,
  NavBtnLink,
  NavLogo
} from './NavbarElements';

const Navbar = () => {
  return (
    <>
      <Nav>
        <NavLink to='/'>
          <NavLogo src={logo}></NavLogo>
        </NavLink>
        <Bars />
        <NavMenu>
          <NavLink to='/tickets' >BUY TICKETS</NavLink>
          <NavLink to='/history' >TICKETS HISTORY</NavLink>
          <NavLink to='/add-route' >ADD ROUTE</NavLink>
          <NavLink to='/list' >LIST</NavLink>
          <NavLink to='/sign-up' >SIGN UP</NavLink>
        </NavMenu>
        <NavBtn>
          <NavBtnLink to='/sign-in'>Sign In</NavBtnLink>
        </NavBtn>
      </Nav>
    </>
  );
};

export default Navbar;