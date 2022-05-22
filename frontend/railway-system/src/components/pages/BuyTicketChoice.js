import React from 'react'
import bg from "../resources/idylla.jpg"
import {useState} from 'react';
import axios from 'axios'
import {connect} from 'react-redux';
import {loggedIn} from '../../reducers/actions'
import {
  Nav,
  NavLink,
  Bars,
  NavMenu,
  NavBtn,
  NavBtnLink,
  NavLogo,
} from '../Navbar/NavbarElements';
function SignIn({isLoggedIn,onLogIn}) {

  const [username, setUsername] = useState('');
  const [password, setPassword] = useState('');
  
  const signIn = () => {
    axios.post("http://localhost:8080/login/submit",
    {
      username:username,
      password:password,
    }
  ).then(response =>{
    console.log(response)
    if(response.status==200){
      console.log(isLoggedIn)
      onLogIn(response.data)
    }
    
  }).catch(error =>{
    console.log(error)
  })
  }


  return (
    <div>SignIn
      <div className="background"><img src={bg}></img></div>
      <div className="form-wrapper">
            <form className = "Form">
                Sign in before buying the ticket in order to:
                <ul>
                    <li>Buy tickets quickly</li>
                    <li>Have access to your tickets</li>
                    
                </ul>
          
            

                <NavBtnLink to='/sign-in' >SIGN IN</NavBtnLink>
                <NavBtnLink to='/tickets/form' >buy logged out</NavBtnLink>

             </form>

        </div>

    </div>
  )
}
const mapStateToProps = state =>({
  isLoggedIn:state.authReducer
})
const mapDispatchToProps = dispatch  => ({
  onLogIn: (response) => dispatch(loggedIn(response))
})

export default connect(mapStateToProps,mapDispatchToProps)(SignIn)