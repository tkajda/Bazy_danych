import React, { useEffect } from 'react'
import '../styles/addRoute_style.css'
import {useState} from 'react';
import axios from 'axios'
import bg from "../resources/idylla.jpg"

class Przystanek {
  constructor(station, arrivalTime, departureTime, id) {
    this.departure = departureTime
    this.arrivalTime = arrivalTime
    this.station = station
    this.id = id
  }
}


function AddRoute() {

  const disablePastDate = () => {
    const today = new Date();
    const dd = String(today.getDate()).padStart(2, "0");
    const mm = String(today.getMonth() + 1).padStart(2, "0"); //January is 0!
    const yyyy = today.getFullYear();
    return yyyy + "-" + mm + "-" + dd;
};
  const [date, setDate] = useState('');
  const [trainNumber, setTrainNumber] = useState('');
  const [station, setStation] = useState('');
  const [destination, setDestination] = useState('');
  const [mainDepartureTime, setMDT] = useState('');
  const [mainArrivalTime,  setMAT] = useState('');
  const [stopName,  setStopName] = useState('');
  const [stopArrival,  setStopArrival] = useState('');
  const [stopDeparture,  setStopDeparture] = useState('');



  const [stops,setStops] = useState([]);

  const addStop = (e) => {
    e.preventDefault();
    const stop = new Przystanek(stopName, stopArrival, stopDeparture, stops.length+1);

    const newStops = [...stops, stop]
    setStops(newStops);
  }

  const postRouteToServer = (e) => {
    e.preventDefault();
    const firstStop = new Przystanek(station, "00-00-00", mainDepartureTime, 0);  
    const finalStops = [firstStop, ...stops]
    setStops(finalStops);


    axios.post('http://localhost:8080?',
    {
      station,
      destination,
      date,
      mainDepartureTime,
      mainArrivalTime,
      stops
    })
    .then( res => console.log(res))
    .catch(error => {
      console.log(error);
    });
    console.log('post request sent');
    window.location.reload(false);
  }




  return (
    <div className="wrapper">
      <h1>Dodaj trase</h1>
      <div className ="flex-menu">
      <div className="column-1">
        <h2>Ogólne Informacje</h2>
        <form className = "Form">

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
              <label>Nr pociągu:</label>
              <input 
                type="text"
                value={trainNumber}
                onChange={(e) => setTrainNumber(e.target.value)}
                required/>
            </span>
            <span>
              <label>Stacja początkowa:</label>
              <input 
                type="text"
                value={station}
                onChange={(e) => setStation(e.target.value)}
                required/>
            </span>
            <span>
              <label>Stacja docelowa:</label>
              <input 
                type="text"
                value={destination}
                onChange={(e) => setDestination(e.target.value)}
                required/>
            </span>
            <span>
              <label>Godzina odjazdu:</label>
              <input 
                type="time"
                value={mainDepartureTime}
                onChange={(e) => setMDT(e.target.value)}
                required/>
            </span>
            <span>
              <label>Godzina przyjazdu do celu:</label>
              <input 
                type="time"
                value={mainArrivalTime}
                onChange={(e) => setMAT(e.target.value)}
                required/>
            </span>

            </form>
        </div>
        <div className = "column">
          <div className="form-wrapper">
              <div className="stopForm-wrapper">
                <h2>Dodaj przystanek</h2>
                <form className="stopForm">
                  <span>
                  <label>Stacja:</label>
                  <input 
                    type="text"
                    value={stopName}
                    onChange={(e) => setStopName(e.target.value)}
                    required/>
                  </span><br></br>
                  <span>
                  <label>Godzina przyjazdu:</label>
                  <input 
                    type="time"
                    value={stopArrival}
                    onChange={(e) => setStopArrival(e.target.value)}
                    required/>
                  </span><br></br>
                  <span>
                  <label>Godzina odjazdu:</label>
                  <input 
                    type="time"
                    value={stopDeparture}
                    onChange={(e) => setStopDeparture(e.target.value)}
                    required/>
                  </span><br></br>
                <button className="button-1" onClick={(e)=>{addStop(e)}}>Dodaj przystanek</button>

                </form>
                <div className = "stops-list">
                  <div className="LIST-STOPS">WSZYSTKIE PRZYSTANKI</div><br/>
                    TRASA:<br/>
                    {station} -{'>'} {destination}<br/>
                    WYJAZD: {mainDepartureTime} <br/>
                    DOJAZD: {mainArrivalTime} <br/>
                    <div>
                    {
                      stops.map(
                        singleStop =>  {
                        return <div className="stop-on-list" key={singleStop.id}> 
                        <span>{singleStop.departure}</span>
                        <span>{singleStop.station}</span>
                        <span>{singleStop.arrivalTime}</span>  
                        </div>
                        }
                      )
                    }
                    </div>
                  </div>
              </div>
        </div>
        <button className="button-2" onClick={e => postRouteToServer(e)}>DODAJ TRASE</button>

      </div>
      
        <div className="background"><img src={bg}></img></div>
      </div>
    </div>
  )
}

export default AddRoute