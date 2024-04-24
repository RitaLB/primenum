import React, { useState } from 'react';
import axios from 'axios';
import InputForm from './components/InputForm';
import ResultDisplay from './components/ResultDisplay';
import ErrorMessage from './components/ErrorMessage';
import History from './components/History';
import './styles.css'

function App() {
  const [number, setNumber] = useState('');
  const [result, setResult] = useState('');
  const [history, setHistory] = useState([]);
  const [errorMessage, setErrorMessage] = useState('');
  const [validationError, setValidationError] = useState('');

  const handleChange = (event) => {
    setNumber(event.target.value);
  };

  const handleCalculate = async () => {
    try {
      const response = await axios.post('http://localhost:9090/api/calculate-primes', { k: number });
      setResult(response.data);
      setErrorMessage('');
      setValidationError('');
      setHistory([]);
    } catch (error) {
      console.error('Error calculating primes:', error);
      if (error.response && error.response.status === 400) {
        setValidationError(error.response.data);
        setResult('');
        setHistory([]);
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
        <InputForm value={number} onChange={handleChange} />
        <button onClick={handleCalculate}>Calculate</button>
        <ResultDisplay result={result} errorMessage={errorMessage} validationError={validationError} history={history} />
        <button onClick={handleViewHistory}>View Search History</button>
        <History history={history} />
      </div>
    </div>
  );
}

export default App;
