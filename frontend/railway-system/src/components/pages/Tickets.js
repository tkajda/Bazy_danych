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



  
  const fetchRoutes = () => {
    axios.get('http://localhost:8080/routes/find',
      {
        params:{
          firstStation: String(start),
          lastStation:String(end),
          departureTime:String(time),
          travelDate:String(date)
        }
      })
      .then(response => {
        console.log(response)
        setTickets(response.data)
      }) 
      .catch(error => {
        console.log(error);
      })

    }

    const buyTicket = (e, index) => {
      console.log(tickets[index])
      console.log('hej')
      axios.post('http://localhost:8080/routes/ticket', 
      {
        trainRouteID: 1,
        startingStation: 'Kraków',
        endingStation: 'Poznań',
        discount: 'STUDENT',
        ticketDate: "22-05-2022",
        travelerName: "Jan",
        travelerSurname: "Kowalski",
        travelerEmail: "ab2@aa.com",
        userId: 1
      })
      .then(response => {
        console.log(response)
      })
      .catch(error=> {
        console.log(error);
      })


    }


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
            <button type="button" onClick={fetchRoutes} >Szukaj</button>

          </form>
          <div className = "list-tickets">
            DOSTĘPNE BILETY

            {
            tickets.map(
              (ticket, index) => <div className="singleTicket" key={ticket.id}>
                  {ticket.firstStation}<br></br>
                  {ticket.lastStation} <br></br>
                  {ticket.departureTime}  <br></br>
                  {ticket.arrivalTime} <br></br>
                  <button onClick={(e) => buyTicket(e, index)}>Wybierz</button>
                </div>
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