import React from 'react';

function History({ history }) {
  return (
    <div id="history">

      {history.length > 0 && (
        <div className="show-history">
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
