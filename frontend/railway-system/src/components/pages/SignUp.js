import React from 'react'
import bg from "../resources/idylla.jpg"
import {useState} from 'react';
import axios from 'axios'


function SignUp() {
  const [username, setUsername] = useState('');
  const [password, setPassword] = useState('');
  const [email, setEmail] = useState('');
  const [firstName, setFirstName] = useState('');
  const [lastName, setLastName] = useState('');
  const [country, setCountry] = useState('');
  const [city, setCity] = useState('');
  const [zip, setZip] = useState('');
  const [address, setAddress] = useState('');


  const registerUser = () =>{
        axios.post("http://localhost:8080/register/submit",
        {
          username:username,
          password:password,
          email:email,
          firstName:firstName,
          lastName:lastName,
          city:city,
          country:country,
          zip:zip,
          address:address
        }
      ).then(response =>{
        console.log(response)
      }).catch(error =>{
        console.log(error)
      })
  }

  return (
    <div>SignUp
      <div className="background"><img src={bg}></img></div>

      <div className ="flex-row-wrapper">

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
            
            <span>
            <label>Email</label><br></br>
            <input 
              type="text"
              required
              value={email}
              onChange={(e) => setEmail(e.target.value)}/>
            </span>

            <span>  
            <label>First name</label><br></br>
            <input 
              type="text"
              value={firstName}
              onChange={(e) => setFirstName(e.target.value)}
              required/>
            </span>

            <span>              
            <label>Last name</label><br></br>
            <input 
              type="text"
              value={lastName}
              onChange={(e) => setLastName(e.target.value)}
              required/>
            </span>

            <span>              
            <label>Country</label><br></br>
            <input 
              type="text"
              value={country}
              onChange={(e) => setCountry(e.target.value)}
              required/>
            </span>

            <span>              
            <label>City</label><br></br>
            <input 
              type="text"
              value={city}
              onChange={(e) => setCity(e.target.value)}
              required/>
            </span>

            <span>              
            <label>Zip code</label><br></br>
            <input 
              type="text"
              value={zip}
              onChange={(e) => setZip(e.target.value)}
              required/>
            </span>

            <span>              
            <label>Address</label><br></br>
            <input 
              type="text"
              value={address}
              onChange={(e) => setAddress(e.target.value)}
              required/>
            </span>

            <button type="button" onClick={registerUser} >Sign up</button>

          </form>

        </div>
      </div>
    </div>
    
  )
}

export default SignUp