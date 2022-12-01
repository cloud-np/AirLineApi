import './App.css'
import { useState } from 'react';
import { Routes, Route } from 'react-router-dom';
import Layout from './components/Layout';
import Dashboard from './pages/Dashboard';
import Login from './pages/Login';
import { LoginContext } from './contexts/LoginContexts';
import Reservations from './pages/Reservations';

function App() {
  const [user, setUser] = useState(null);

  const logTypes = [true, false].map(value => (
    <LoginContext.Provider value={{user, setUser, isForLogin: value}}>
      <Login />
    </LoginContext.Provider>
  ));

  // Do not let user pass to the next page if they are not logged in
  if (!user && !window.location.href.endsWith('/signup')) return logTypes[0];

  return (
    <Routes className="App">
      <Route path="/" element={<Dashboard />} />
      <Route path="/login" element={logTypes[0]} />
      <Route path="/signup" element={logTypes[1]} />
      <Route path="/reservations" element={<Reservations />} />
    </Routes>
  )
}

export default App
