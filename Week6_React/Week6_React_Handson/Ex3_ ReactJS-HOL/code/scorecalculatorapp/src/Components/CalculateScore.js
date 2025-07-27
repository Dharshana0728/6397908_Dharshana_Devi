import React from 'react';
import '../Stylesheets/mystyle.css';  // Import CSS styles

function CalculateScore(props) {
  // Destructure props for readability
  const { Name, School, Total, Goal } = props;

  // Calculate average score
  const average = Total / Goal;

  return (
    <div className="score-container">
      <h2>Student Score Card</h2>
      <p><strong>Name:</strong> {Name}</p>
      <p><strong>School:</strong> {School}</p>
      <p><strong>Total Score:</strong> {Total}</p>
      <p><strong>Goal:</strong> {Goal}</p>
      <p><strong>Average Score:</strong> {average.toFixed(2)}</p>
    </div>
  );
}

export default CalculateScore;
