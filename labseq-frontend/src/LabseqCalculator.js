import React, { useState } from 'react';
import { getLabseqValue } from '../src/labseqService';

const LabseqCalculator = () => {
  const [n, setN] = useState('');
  const [result, setResult] = useState(null);
  const [error, setError] = useState(null);

  const handleSubmit = async (event) => {
    event.preventDefault();
    if (n < 0) {
      setError('Error: The value must be a non-negative integer.');
      setResult(null);
      return;
    }

    try {
      const data = await getLabseqValue(n);
      setResult(data);
      setError(null);
    } catch (err) {
      console.error('Error:', err);
      setError('An error occurred while fetching the result.');
      setResult(null);
    }
  };

  return (
    <div>
      <h1>Labseq Sequence Calculator</h1>
      <form onSubmit={handleSubmit}>
        <label htmlFor="n">Enter n: </label>
        <input
          type="number"
          id="n"
          name="n"
          min="0"
          value={n}
          onChange={(e) => setN(e.target.value)}
          required
        />
        <button type="submit">Calculate</button>
      </form>
      {result !== null && <p>Result: {result}</p>}
      {error && <p>{error}</p>}
    </div>
  );
};

export default LabseqCalculator;
