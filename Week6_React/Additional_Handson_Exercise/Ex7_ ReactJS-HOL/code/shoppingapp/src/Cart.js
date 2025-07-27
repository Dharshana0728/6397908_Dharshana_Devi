import React, { Component } from 'react';

class Cart extends Component {
  render() {
    const { itemName, price } = this.props;
    
    return (
      <div style={{ border: '1px solid gray', padding: '10px', margin: '10px', width: '300px' }}>
        <h3>Item: {itemName}</h3>
        <p>Price: ${price}</p>
      </div>
    );
  }
}

export default Cart;
