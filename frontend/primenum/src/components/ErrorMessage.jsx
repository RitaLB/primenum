import React from 'react';

function ErrorMessage({ errorMessage }) {
  return (
    <div className="error-message">
      <p>{errorMessage}</p>
    </div>
  );
}

export default ErrorMessage;
