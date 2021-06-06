import React from 'react';
import ReactDOM from 'react-dom';
import './index.css';
import './board.css'; 
  

class IceCream extends React.Component{
  constructor(props){
    super(props);
    this.state = {value:'strawberry'};

    this.handleChange = this.handleChange.bind(this);
    this.handleSubmit = this.handleSubmit.bind(this);
  }

  handleChange(event){
    this.setState({value:event.target.value});
  }

  handleSubmit(event){
    alert ('You have chose flavour '+ this.state.value);
    event.preventDefault();
  }

  render() {
    return (
      <form onSubmit ={this.handleSubmit}>

        <label>
          Choose your flavour :
          <select value ={this.state.value} onChange={this.handleChange}>
            <option value ="rumrasin">Rum and Rasin</option>
            <option value ="strawberry">Strawberry</option>
            <option value ="belgiumchocolate">Belgium Chocolate</option>
          </select>
        </label>
        <input type ="submit" value="Submit"/>
      </form>
    )
  }
}


ReactDOM.render(
  <IceCream />,
  document.getElementById('root')
);
