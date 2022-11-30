import './App.css'
import serverInstance from './api/axiosInstance';
import { useState } from 'react';
import userEndPoints from './api/userEndPoints';
import UserDataForm from './components/UserDataForm';
import { Routes, Route } from 'react-router-dom';
import Layout from './components/Layout';

function App() {
  const [user, setUser] = useState(null);
  // useEffect(() => {
  //   const test = async () => {
  //     const response = await serverInstance.get(userEndPoints.test);
  //     console.log(response);
  //   }
  //   test();
  // }, []);
  if (!user)
    return <Layout><UserDataForm isForLogin={true} /></Layout>

  return (
    <Routes className="App">
      <Route path="/" element={<div>Home</div>} />
      <Route path="/login" element={<Layout><UserDataForm isForLogin={true} /></Layout>} />
      <Route path="/signup" element={<Layout><UserDataForm isForLogin={false} /></Layout>} />
    </Routes>
  )
}

export default App
