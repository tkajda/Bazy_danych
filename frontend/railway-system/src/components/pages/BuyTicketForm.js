import React from 'react'
import bg from "../resources/idylla.jpg"
import {useState} from 'react';
import axios from 'axios'
import {connect} from 'react-redux';
import {useLocation} from 'react-router-dom'

function SignUp({authData,route}) {
  const [email, setEmail] = useState('');
  const [firstName, setFirstName] = useState('');
  const [lastName, setLastName] = useState('');
  const [country, setCountry] = useState('');
  const [city, setCity] = useState('');
  const [zip, setZip] = useState('');
  const [address, setAddress] = useState('');
  const [compartment, setCompartment]=useState(false);
  const [discount, setDiscount]=useState("STUDENT")
  var buyTicket;
  let hejka=authData
  let location=useLocation();
  if(authData.isLoggedIn){
      
      console.log(authData)
      console.log("TU")
      buyTicket = () =>{
        axios.post("http://localhost:8080/routes/ticket",
        {
          routeID:route.route.routeID,
          startingStation:route.route.firstStation,
          endingStation:route.route.lastStation,
          discount:discount,
          travelerName:firstName,
          travelerSurname:lastName,
          travelerEmail:email,
          userId:authData.authData.userAuthData.userID,
          compartmentSeat:compartment,
          travelerCountry:country,
          travelerCity:city,
          travelerZip:zip,
          travelerAddress:address
        }
      ).then(response =>{
        console.log(response)
      }).catch(error =>{
        console.log(error)
      })
    }

  }
  else{
    console.log("TU2")
    buyTicket = () =>{
      
      console.log(route)
      console.log(route.route.firstStation)
      console.log(route.route.lastStation)
      axios.post("http://localhost:8080/routes/ticket",
      {
        routeID:route.route.routeID,
        startingStation:route.route.firstStation,
        endingStation:route.route.lastStation,
        discount:discount,
        travelerName:firstName,
        travelerSurname:lastName,
        travelerEmail:email,
        compartmentSeat:compartment,
        travelerCountry:country,
        travelerCity:city,
        travelerZip:zip,
        travelerAddress:address
      }
    ).then(response =>{
      console.log(response)
    }).catch(error =>{
      console.log(error)
    })
}
  }
  
  console.log(String(route.route.routeID))
  console.log(route)
  return (
    <div>SignUp
      <div className="background"><img src={bg}></img></div>

      <div className ="flex-row-wrapper">

        <div className="form-wrapper">
          <form className = "Form">
            
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

            <span>              
            <label>Discount</label><br></br>
            <input 
              type="text"
              value={discount}
              onChange={(e) => setDiscount(e.target.value)}
              required/>
            </span>

            <span>              
            <label>Compartment</label><br></br>
            <input 
              type="text"
              value={compartment}
              onChange={(e) => setCompartment(e.target.value)}
              required/>
            </span>

            <button type="button" onClick={buyTicket} >Buy ticket</button>

          </form>

        </div>
      </div>
    </div>
    
  )
}

const mapStateToProps = state =>({
  authData:state.authReducer,
  route:state.chosenRoute
})

export default connect(mapStateToProps)(SignUp)