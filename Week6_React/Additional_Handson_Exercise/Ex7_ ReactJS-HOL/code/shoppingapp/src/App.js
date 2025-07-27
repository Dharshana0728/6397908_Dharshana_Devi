import React from 'react';
import './App.css';

function App() {
  // List of items—replace, add, or adjust as needed
  const items = [
    { name: "Laptop", price: 80000 },
    { name: "TV", price: 120000 },
    { name: "Washing Machine", price: 50000 },
    { name: "Mobile", price: 30000 },
    { name: "Fridge", price: 70000 }
  ];

  return (
    <div className="app-container">
      <h1 className="title">Items Ordered :</h1>
      <table className="items-table">
        <thead>
          <tr>
            <th>Name</th>
            <th>Price</th>
          </tr>
        </thead>
        <tbody>
          {items.map((item, idx) => (
            <tr key={idx}>
              <td>{item.name}</td>
              <td>{item.price}</td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
}

export default App;
