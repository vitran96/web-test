import { useEffect, useState } from 'react'
import reactLogo from './assets/react.svg'
import viteLogo from '/vite.svg'
import './App.css'

const SERVER_URL = import.meta.env.DEV ?
  'http://localhost:8080' :
  '';

function App() {
  const [count, setCount] = useState(0);
  const [message, setMessage] = useState('Loading');

  // console.log(`${SERVER_URL}/api/hello`)

  useEffect(() => {
    fetch(`${SERVER_URL}/api/hello`)
      .then(response => response.json())
      .then(data => {
        // console.log(data);
        setTimeout(
          () => {
            setMessage(data.message);
          }
          , 1000);
      });
  }, []);

  return (
    <>
      <div>
        <a href="https://vitejs.dev" target="_blank" rel="noopener">
          <img src={viteLogo} className="logo" alt="Vite logo" />
        </a>
        <a href="https://react.dev" target="_blank" rel="noopener">
          <img src={reactLogo} className="logo react" alt="React logo" />
        </a>
      </div>
      <h1>Vite + React</h1>
      <div className="card">
        <button onClick={() => setCount((count) => count + 1)}>
          count is {count}
        </button>
        <p>
          Edit <code>src/App.tsx</code> and save to test HMR
        </p>
      </div>
      <p className="read-the-docs">
        Click on the Vite and React logos to learn more
      </p>
      <p>Message from server: {message}</p>
    </>
  )
}

export default App
