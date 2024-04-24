import React from 'react';

function InputForm({ value, onChange }) {
  return (
    <div>
      <h2>How many prime numbers smaller than "{value}" are there?</h2>
      <input type="text" value={value} onChange={onChange} />
    </div>
  );
}

export default InputForm;
