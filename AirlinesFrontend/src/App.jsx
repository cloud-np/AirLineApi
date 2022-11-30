import './App.css'
import serverInstance from './api/axiosInstance';
import { useEffect } from 'react';
import userEndPoints from './api/userEndPoints';

function App() {

  useEffect(() => {
    const test = async () => {
      const response = await serverInstance.get(userEndPoints.test);
      console.log(response);
    }
    test();
  }, []);

  return (
    <div className="App">
    </div>
  )
}

export default App
