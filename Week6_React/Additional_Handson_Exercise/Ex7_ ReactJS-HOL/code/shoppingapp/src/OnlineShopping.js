import React, { Component } from 'react';
import Cart from './Cart';

class OnlineShopping extends Component {
  constructor(props) {
    super(props);
    // Initialize an array of 5 items (Cart)
    this.state = {
      items: [
        { id: 1, itemName: 'Laptop', price: 79999 },
        { id: 2, itemName: 'Samsung Galaxy S21', price: 69999 },
        { id: 3, itemName: 'TV', price: 29900 },
        { id: 4, itemName: 'Washing Machine', price: 21299 },
        { id: 5, itemName: 'Fridge', price: 24999 }
      ]
    };
  }

  render() {
    return (
      <div>
        <h1>Online Shopping Cart</h1>
        {/* Loop through items and render Cart components with props */}
        {this.state.items.map(item => (
          <Cart 
            key={item.id} 
            itemName={item.itemName} 
            price={item.price} 
          />
        ))}
      </div>
    );
  }
}

export default OnlineShopping;
