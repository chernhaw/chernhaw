import { render } from '@testing-library/react';
import React from 'react';
import ReactDOM from 'react-dom';
import './index.css';
import './board.css';

class GuessAnumber extends React.Component{
  constructor(props){
    super(props);
  //  var correctNo =Math.floor(Math.random() * 10);
  //  this.state= {correctNumber: correctNo}
    this.state= {guessNumber:0}

    this.handleChange = this.handleChange.bind(this);
    this.handleSubmit = this.handleSubmit.bind(this);
  }

  handleChange(event){
    this.setState({guessNumber:event.target.value});
    
  }

  handleSubmit(event){
    var correctNo =Math.floor(Math.random() * 10);
    if (this.state.guessNumber==correctNo){
      alert('Your guessed correctly !  '+this.state.guessNumber+ 
    ' and the correctNumber is ' +correctNo+ "");
    } else{
    alert('Number you guessed is '+this.state.guessNumber+ 
    ' and the correctNumber is ' +correctNo);
    }
  }

  render(){
    return (
      <form onSubmit = {this.handleSubmit}>
        <label>
        Guess Number :
        <input type ="text" value= {this.state.guessNumber} onChange={this.handleChange}/>
        </label>
        <input type ="submit" value="Submit" />
      </form>
    );

  }
}

ReactDOM.render(
   <GuessAnumber />,
   document.getElementById('root')
 );
