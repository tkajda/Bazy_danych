import React from 'react'
import bg from "../resources/idylla.jpg"
import '../styles/tickets_style.css'
import {useState} from 'react';
import axios from 'axios'
import {connect} from 'react-redux';
import {useLocation} from 'react-router-dom'

function SignUp({authData,route}) {
  
  const [email, setEmail] = useState(() => {if(authData.isLoggedIn){return authData.authData.userAuthData.email} else{ return ""}});
  const [firstName, setFirstName] = useState(() => {if(authData.isLoggedIn){return authData.authData.userAuthData.firstName} else{ return ""}});
  const [lastName, setLastName] = useState(() => {if(authData.isLoggedIn){return authData.authData.userAuthData.lastName} else{ return ""}});
  const [country, setCountry] = useState(() => {if(authData.isLoggedIn){return authData.authData.userAuthData.country} else{ return ""}});
  const [city, setCity] = useState(() => {if(authData.isLoggedIn){return authData.authData.userAuthData.city} else{ return ""}});
  const [zip, setZip] = useState(() => {if(authData.isLoggedIn){return authData.authData.userAuthData.zip} else{ return ""}});
  const [address, setAddress] = useState(() => {if(authData.isLoggedIn){return authData.authData.userAuthData.address} else{ return ""}});
  const [compartment, setCompartment]=useState(false);
  const [discount, setDiscount]=useState("STUDENT")
  const [msg,setMsg]=useState("Wpisz dane")
  
  var buyTicket;
  console.log(authData)
  if(authData.isLoggedIn){
      
      console.log(authData)
      console.log("TU")
      
      /*let userData=authData.authData.userAuthData
      setFirstName(userData.firstName)
      setLastName(userData.lastName)
      setEmail(userData.email)
      setCity(userData.city)
      setCountry(userData.country)
      setZip(userData.zip)
      setAddress(userData.address)*/

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
        setMsg("Kupiono bilet")
        console.log(response)

      }).catch(error =>{
        setMsg("Brak miejsc")
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
      window.alert("Udalo ci sie kupic bilet")
      setMsg("Udalo sie kupic bilet")
      console.log(response)
    }).catch(error =>{
      window.alert("Brak miejsc!");
      setMsg("Brak miejsc w wybranym wagonie na wybrane polaczenie")
      console.log(error)
    })
}
  }
  const handleChange = (ev) => {
    setCompartment(ev.target.value);
  }
  const handleDiscountChange = (ev) => {
    setDiscount(ev.target.value);
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
            <select value={discount} onChange={handleDiscountChange}>
              <option value="NONE">none</option>
              <option value="STUDENT">student</option>
              <option value="WORKER">worker</option>
              <option value="DISABILITY">disability</option>
            </select>
            </span>
            <span>              
            <label>Compartment</label><br></br>
            <select value={compartment} onChange={handleChange}>
              <option value="true">true</option>
              <option value="false">false</option>
            </select>
            </span>

            <button type="button" onClick={buyTicket} >Buy ticket</button>

          </form>

        </div>
        <div className="msg">
          {msg}
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