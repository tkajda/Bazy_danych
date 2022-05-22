import React from 'react';
import logo from '../resources/LOGO.png'
import {connect} from 'react-redux';
import { loggedOut } from '../../reducers/actions';
import {configureStore} from '../../store'
import {
  Nav,
  NavLink,
  Bars,
  NavMenu,
  NavBtn,
  NavBtnLink,
  NavLogo,
} from './NavbarElements';

const Navbar = ({isLoggedIn,logOut}) => {
  console.log(isLoggedIn);
  
  return (
    <>
      <Nav>
        <NavLink to='/'>
          <NavLogo src={logo}></NavLogo>
        </NavLink>
        <Bars />
        <NavMenu>
          <NavLink to='/tickets' >BUY TICKETS</NavLink>
          {isLoggedIn.isLoggedIn?<NavLink to='/history' >TICKETS HISTORY</NavLink>:<></>}
          <NavLink to='/add-route' >ADD ROUTE</NavLink>
          {!isLoggedIn.isLoggedIn?<NavLink to={{pathname:'sign-up'}}>SIGN UP</NavLink>:<></>}
        </NavMenu>
        <NavBtn>
        {!isLoggedIn.isLoggedIn?<NavBtnLink to={{pathname:'/sign-in'}}>Sign In</NavBtnLink>:<></>}
        {isLoggedIn.isLoggedIn?<NavBtnLink onClick={()=> logOut()} to={{pathname:'/'}}>Sign Out</NavBtnLink>:<></>}
          
          
        </NavBtn>
      </Nav>
    </>
  );
};
const mapStateToProps = state =>({
  isLoggedIn:state.authReducer
})
const mapDispatchToProps = dispatch  => ({
  logOut: (response) => dispatch(loggedOut(response))
})
export default connect(mapStateToProps)(Navbar);