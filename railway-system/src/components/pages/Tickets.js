import React from 'react'

function Tickets() {

  const disablePastDate = () => {
    const today = new Date();
    const dd = String(today.getDate()).padStart(2, "0");
    const mm = String(today.getMonth() + 1).padStart(2, "0"); //January is 0!
    const yyyy = today.getFullYear();
    return yyyy + "-" + mm + "-" + dd;
};


  return (
    <div>
      <div>Tickets</div>
      <form>
        <label>Skąd:</label>
        <input type="text" required/>

        <label>Dokąd:</label>
        <input type="text" required/>

        <label>Data:</label>
        <input type="date" min={disablePastDate()} required/>
        <label>Godzina:</label>
        <input type="time" required/>

      </form>
    </div>

  )
}

export default Tickets