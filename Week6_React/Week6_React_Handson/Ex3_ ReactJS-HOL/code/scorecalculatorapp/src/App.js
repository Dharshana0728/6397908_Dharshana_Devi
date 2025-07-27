import React from 'react';
import CalculateScore from './Components/CalculateScore';

function App() {
  return (
    <div>
      <CalculateScore Name="Alice Johnson" School="Greenwood High" Total={450} Goal={500} />
      <CalculateScore Name="Bob Smith" School="Sunshine Elementary" Total={380} Goal={400} />
    </div>
  );
}

export default App;
