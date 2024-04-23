import React, { useState, useEffect } from 'react';
import axios from 'axios';

function History() {
    const [history, setHistory] = useState('');
    const [errorMessage, setErrorMessage] = useState('');
    const [mounted, setMounted] = useState(false);

    useEffect(() => {
        if (mounted) {
            fetchHistory();
        } else {
            setMounted(true);
        }
    }, [mounted]);

    const fetchHistory = async () => {
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
        <div id="history">
            <h1>History</h1>

            {errorMessage && (
                <div className="error-message">
                    <p>{errorMessage}</p>
                </div>
            )}

            {history && (
                <div className="show_history">
                    <h2>Search History</h2>
                    <ul>
                        {history.map((item, index) => (
                            <li key={index}>Number: {item.number}, Result: {item.result}, Calculation Time: {item.calculationTime}</li>
                        ))}
                    </ul>
                </div>
            )}
        </div>
    );
}

export default History;
