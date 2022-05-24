import React from 'react'
import bg from "../resources/idylla.jpg"
import {useState} from 'react';
import axios from 'axios'
import {connect} from 'react-redux';
import {loggedIn} from '../../reducers/actions'
function SignIn({isLoggedIn,onLogIn}) {

  const [username, setUsername] = useState('');
  const [password, setPassword] = useState('');
  const [msg, setMsg]=useState("zaloguj sie")
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
      setMsg("Zalogowano")
    }
    
  }).catch(error =>{
    console.log(error)
    setMsg("Nie udalo sie zalogowac")
  })
  }


  return (
    <div>SignIn
      <div className="background"><img src={bg}></img></div>
      <div className="form-wrapper">
          <form className = "Form">
            <span>
              <label>Username</label><br></br>
              <input
                type="text" 
                required
                value={username}
                onChange={(e) => setUsername(e.target.value)}/>
            </span>
          
            <span>
            <label>Password</label><br></br>
            <input 
              type="password"
              value={password}
              onChange={(e) => setPassword(e.target.value)}
              required/>
            </span>
            

            <button type="button" onClick={signIn} >Sign up</button>
            <br></br>
            {msg}

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