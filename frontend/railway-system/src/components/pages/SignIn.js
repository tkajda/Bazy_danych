import React from 'react'
import bg from "../resources/idylla.jpg"
import {useState} from 'react';
import axios from 'axios'

function SignIn() {

  const [username, setUsername] = useState('');
  const [password, setPassword] = useState('');

  const signIn = () => {
    console.log(username)
    console.log(password)
    axios.post("http://localhost:8080/login/submit",
    {
      username:username,
      password:password,
    }
  ).then(response =>{
    console.log(response)
  }).catch(error =>{
    console.log(error)
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

          </form>

        </div>

    </div>
  )
}

export default SignIn