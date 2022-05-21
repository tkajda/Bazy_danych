import React, { useEffect } from 'react'
import '../styles/history_style.css'
import bg from "../resources/idylla.jpg"
import {useState} from 'react';
import axios from 'axios'


function History() {

  const [tickets, setTickets] = useState([]);


  const myId = 0;

  
  useEffect(
    () => {axios.get('http://localhost:8080/routes/tickets',
    {
      params:{
        userID:3
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
                {ticket.travelerSurname}<br></br><br></br><br></br>
                {/* {ticket.start}  
                {ticket.end}  
                {ticket.date}  
                {ticket.type}   */}
              </div>
            ) ) 
          }

        </div>
        <div className="background"><img src={bg}></img></div>
      </div>

  )
}

export default History