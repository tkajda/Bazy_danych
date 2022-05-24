import React, { useEffect } from 'react'
import '../styles/history_style.css'
import bg from "../resources/idylla.jpg"
import {useState} from 'react';
import axios from 'axios'
import { connect } from 'react-redux';


function History(authData) {

  const [tickets, setTickets] = useState([]);

  useEffect(
    () => {axios.get('http://localhost:8080/routes/tickets',
    {
      params:{
        userID:authData.authData.authData.userAuthData.userID
      }
    })
    .then(response => {
      console.log(response)
      setTickets(response.data)
    }) 
    .catch(error => {
      console.log(error);
    })
  },[]  
  )
  
    

  return (
    
    <div className="wrapper">
      <h1>Twoje bilety</h1>
        <div className="ticket-list">
          {
          tickets.map(
            ticket => (
              <div className="ticket" key={ticket.id}>
                {ticket.startingStation}<br></br>
                {ticket.endingStation}<br></br>
                {ticket.ticketDate}<br></br>
                {ticket.travelerName}<br></br>
                {ticket.travelerSurname}<br></br>
                Miejsce{ticket.seatNo}<br></br>
                Przedzialowy:{String(ticket.compartmentSeat)}<br></br>
                Cena:{ticket.price}
                <br></br><br></br>
              </div>
            ) ) 
          }

        </div>
        <div className="background"><img src={bg}></img></div>
      </div>

  )
}

const mapStateToProps = state =>({
  authData:state.authReducer
})

export default connect(mapStateToProps)(History)