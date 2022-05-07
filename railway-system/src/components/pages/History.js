import React, { useEffect } from 'react'
import '../styles/history_style.css'
import {useState} from 'react';
import axios from 'axios'


function History() {

  const [tickets, setTickets] = useState([]);


  const myId = 0;

  // function fetchTickets() {
  //   useEffect(() => {
  //     axios.get('localhost:8080/routes/tickets',
  //       {
  //         params: {
  //           id: {myId}
  //         }
  //       }
  //       .then(response => {
  //         console.log(response)
  //         setTickets({tickets: response.data})
  //       }) 
  //       .catch(error => {
  //         console.log(error);
  //       })
  
  //     )}, [])
  // }
  
  const x = 0;
  const reloadUseEffect = () => {
    x = Math.random();
  }


  useEffect(() => {
    axios.get('https://jsonplaceholder.typicode.com/posts',
      {
        params: {
          id: 1
        }
      })
      .then(response => {
        console.log(response)
        setTickets(response.data)
        console.log(tickets);
      }) 
      .catch(error => {
        console.log(error);
      })

    }, [x])
  




  return (
    <div className="wrapper">
      <h1>Twoje bilety</h1>
        <div className="ticket-list">
        
          {
          tickets.map(
            ticket => (
              <div className="ticket" key={ticket.id}>
                {ticket.title}
                {/* {ticket.start}  
                {ticket.end}  
                {ticket.date}  
                {ticket.type}   */}
              </div>
            ) ) 
          }
          
        </div>
      </div>

  )
}

export default History