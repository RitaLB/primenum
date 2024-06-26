//import './App.css'
import './styles.css'
import React, { useState } from 'react';
import axios from 'axios';
import Sidebar from './components/Sidebar';

function App() {
  const [number, setNumber] = useState('');
  const [result, setResult] = useState('');
  const [history, setHistory] = useState('');
  const [errorMessage, setErrorMessage] = useState('');
  const [validationError, setValidationError] = useState('');

  const handleChange = (event) => {
    setNumber(event.target.value);
  };

  const handleCalculate = async () => {
    try {
      const response = await axios.post('http://localhost:9090/api/calculate-primes', { k: number });
      console.log(response.data);
      setResult(response.data);
      setErrorMessage('');
      setValidationError('');
      setHistory('');
    } catch (error) {
      console.error('Error calculating primes:', error);
      if (error.response && error.response.status === 400) {
        setValidationError(error.response.data);
        setResult('');
        setHistory('');
      } else {
        setErrorMessage('Fail to calculate. Connection failed.');
      }
    }
  };

  const handleViewHistory = async () => {
    try {
      const response = await axios.get('http://localhost:9090/api/history');
      setHistory(response.data);
      setErrorMessage('');
    } catch (error) {
      console.error('Error fetching search history:', error);
      setErrorMessage('Fail to fetch search history. Connection failed.');
    }
  };

  return (
    <div className="container">
      <div className="content">
        <h1>PrimeNum</h1>
        <h2>How many prime numbers smaller than "{number}" are there?</h2>
        <input type="text" value={number} onChange={handleChange} />
        <button onClick={handleCalculate}>Calculate</button>
        
        {result && (
          <div className="result">
            <h3>Result</h3>
            <p>
              Result: {result.result}, Calculation Time: {result.processingTime} </p>
          </div>
        )}

        {errorMessage && (
          <div className="error-message">
            <p>{errorMessage}</p>
          </div>
        )}
        {validationError && (
          <div className="validation-error">
            <p>{validationError}</p>
          </div>
        )}

        <button onClick={handleViewHistory}>View Search History</button>

        {history && (
          <div className="history">
            <h3>Search History</h3>
            <ul>
              {history.map((item, index) => (
                <li key={index}>Number: {item.number}, Result: {item.result}, Calculation Time: {item.calculationTime}</li>
              ))}
            </ul>
          </div>
        )}
        </div>
    </div>
  );
}

export default App;

