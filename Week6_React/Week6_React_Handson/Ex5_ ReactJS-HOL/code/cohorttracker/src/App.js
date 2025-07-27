import React from 'react';
import CohortDetails from './CohortDetails';

const cohorts = [
  {
    name: "INTADMDF10 - .NET FSD",
    startedOn: "22-Feb-2022",
    status: "Scheduled",
    coach: "Aathma",
    trainer: "Jojo Jose",
  },
  {
    name: "ADM21JF014 - Java FSD",
    startedOn: "10-Sep-2021",
    status: "Ongoing",
    coach: "Apoorv",
    trainer: "Elisa Smith",
  },
  {
    name: "CDBJF21025 - Java FSD",
    startedOn: "24-Dec-2021",
    status: "Ongoing",
    coach: "Aathma",
    trainer: "John Doe",
  }
];

function App() {
  return (
    <div style={{ display: 'flex', flexWrap: 'wrap', background: "#fafafa", minHeight: "100vh" }}>
      {cohorts.map((cohort, idx) => (
        <CohortDetails key={idx} cohort={cohort} />
      ))}
    </div>
  );
}

export default App;
