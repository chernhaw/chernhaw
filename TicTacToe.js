import { render } from '@testing-library/react';
import React from 'react';
import ReactDOM from 'react-dom';
import {useForm} from "react-hook-form";
import './board.css';
import './App.css';
import Button from '@material-ui/core/Button';


 We’ll now add handleClick to the Board class added material ui
 
class Square extends React.Component {

  constructor(props){
    super(props);
    this.state = {
      value : null,
    };

  }

  render (){
    return (

    //  <button className="square" onClick={()=>this.props.onClick()}>
    //   {this.props.value}
    // </button>

    // FUN https://material-ui.com/getting-started/usage/
    <Button variant="contained" color="primary" onClick={()=>this.props.onClick()}>
      {this.props.value}
    </Button>
    
    );
    
  }
}

class Board extends React.Component{

  constructor(props) {
    super(props);
      this.state = {
        squares: Array(9).fill(null),
      };
    }

    handleClick(i){
      const squares = this.state.squares.slice();
      squares[i] ='X';
      this.setState({squares:squares});
    }
  
  renderSquare(i){
    return (
    <Square 
      value = {this.state.squares[i]} 
      onClick ={()=> this.handleClick(i)}
      />
      );
 
  }

  render() {
    const status='Next player: X';
    return (
      <div>
          <div className="status">{status} </div>
          <div className ="board-row">
            {this.renderSquare(0)}

            {this.renderSquare(1)}
            {this.renderSquare(2)}
          </div>
          <div className ="board-row">
            {this.renderSquare(3)}
            {this.renderSquare(4)}
            {this.renderSquare(5)}
          </div>
          <div className="board-row">
            {this.renderSquare(6)}
            {this.renderSquare(7)}
            {this.renderSquare(8)}
          </div>

      </div>

    );
  }
}

class Game extends React.Component {
  render(){
    return (
      <div className="game">
        <div className="game-board">
          <Board />
        </div>
      <div className="game-info">
        
          <div>{/* status */} </div>
          <ol>{/* TODO */ }</ol>
        </div>
      </div>

    );
  }
}

ReactDOM.render(
  <Game />,
  document.getElementById('root')
);
