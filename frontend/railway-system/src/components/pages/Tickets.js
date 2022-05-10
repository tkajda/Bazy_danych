import React, { useEffect } from 'react'
import '../styles/tickets_style.css'
import {useState} from 'react';
import axios from 'axios'
import bg from "../resources/idylla.jpg"


function Tickets() {

  const disablePastDate = () => {
    const today = new Date();
    const dd = String(today.getDate()).padStart(2, "0");
    const mm = String(today.getMonth() + 1).padStart(2, "0"); //January is 0!
    const yyyy = today.getFullYear();
    return yyyy + "-" + mm + "-" + dd;
};

  const [start, setStart] = useState('');
  const [end, setEnd] = useState('');
  const [date, setDate] = useState('');
  const [time, setTime] = useState('');
  const [type, setType] = useState('Przedzialowy');

  const [tickets, setTickets] = useState([]);



  // function fetchTickets() {
  //   useEffect(() => {
  //     axios.get('localhost:8080/routes/tickets',
  //       {
  //         params: {
  //           start: {start},
  //           end: {end},
  //           date: {date},
  //           time: {time}
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
    <div className = "wrapper">
      <h1>Wybierz bilet</h1>
      <div className ="flex-row-wrapper">

        <div className="form-wrapper">
          <form className = "Form">
            <span>
              <label>Skąd:</label>
              <input
                type="text" 
                required
                value={start}
                onChange={(e) => setStart(e.target.value)}/>
            </span>
          
            <span>
            <label>Dokąd:</label>
            <input 
              type="text"
              value={end}
              onChange={(e) => setEnd(e.target.value)}
              required/>
            </span>
            <span>

            <label>Data:</label>
            <input 
              type="date"
              min={disablePastDate()} 
              required
              value={date}
              onChange={(e) => setDate(e.target.value)}/>
            </span>
            <span>
              
            <label>Godzina:</label>
            <input 
              type="time"
              value={time}
              onChange={(e) => setTime(e.target.value)}
              required/>
            </span>

            <select 
              value={type}
              onChange={(e) => setType(e.target.value)}>
              <option value="Przedzialowy">Przedzialowy</option>
              <option value="Bezprzedzialowy">Bezprzedzialowy</option>
            </select>
            <button onClick={reloadUseEffect} >Szukaj</button>

          </form>
          <div className = "list-tickets">
            LIST OF TICKETS

            {
            tickets.map(
              ticket => <div className="singleTicket" key={ticket.id}>{ticket.title}</div>
              ) 
            }


          </div>
        </div>
      </div>

      <div className="background"><img src={bg}></img></div>
    </div>

  )
}

export default Tickets