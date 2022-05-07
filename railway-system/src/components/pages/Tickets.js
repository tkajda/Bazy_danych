import React from 'react'
import '../styles/tickets_style.css'
import {useState} from 'react';


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

  return (
    <div>
      <h1>Wybierz bilet</h1>
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
        <button>Szukaj</button>


      </form>
      </div>
    </div>

  )
}

export default Tickets