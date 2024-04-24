import React from 'react';

function ResultDisplay({ result, errorMessage, validationError }) {
  return (
    <div>
      {result && (
        <div className="result">
          <h2>Result</h2>
          <p>Result: {result.result}, Calculation Time: {result.processingTime}</p>
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

      
    </div>
  );
}

export default ResultDisplay;
