import React, { useState } from 'react';

function StateDemo() {
  const [entered, setEntered] = useState(0);
  const [left, setLeft] = useState(0);

  const handleLogin = () => {
    setEntered(entered + 1);
  };

  const handleExit = () => {
    setLeft(left + 1);
  };

  return (
    <div style={{ display: "flex", justifyContent: "space-around", marginTop: "100px" }}>
      <div>
        <button
          style={{
            background: "#d1ffd1",
            border: "1px solid #3cb371",
            borderRadius: "4px",
            padding: "4px 12px",
            fontWeight: "bold",
            color: "#065f46",
            marginRight: "8px"
          }}
          onClick={handleLogin}
        >
          Login
        </button>
        <span>
          {entered} People Entered!!!
        </span>
      </div>
      <div>
        <button
          style={{
            background: "#d1ffd1",
            border: "1px solid #3cb371",
            borderRadius: "4px",
            padding: "4px 12px",
            fontWeight: "bold",
            color: "#065f46",
            marginRight: "8px"
          }}
          onClick={handleExit}
        >
          Exit
        </button>
        <span>
          {left} People Left!!!
        </span>
      </div>
    </div>
  );
}

export default StateDemo;
