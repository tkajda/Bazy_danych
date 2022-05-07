import Navbar from './components/Navbar'
import { BrowserRouter as Router, Route, Routes } from 'react-router-dom';
import Home from './components/pages/Home'
import Tickets from './components/pages/Tickets'
import History from './components/pages/History'
import AddRoute from './components/pages/AddRoute'
import SignIn from './components/pages/SignIn'
import SignUp from './components/pages/SignUp'
import List from './components/pages/List'


function App() {
  return (
    <> 

    <Router>
      <Navbar></Navbar>
      <Routes>

        <Route path="/" element= {<Home />} />
        <Route path="/history" element= {<History />} />
        <Route path="/tickets" element= {<Tickets />} />
        <Route path="/add-route" element= {<AddRoute />} />
        <Route path="/list" element= {<List />} />
        <Route path="/sign-up" element= {<SignUp />} />
        <Route path="/sing-in" element= {<SignIn />} />
      </Routes>
    </Router>
    </>
    

      
  );
}

export default App;
