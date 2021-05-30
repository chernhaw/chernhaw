
class Counter extends React.Component{
  constructor(props){
    super(props);
     this.state = {count: 0};
     
     console.log("The counter is now ---->" + this.state.count);

     ///1)
     this.handleIncreaseClick = this.handleIncreaseClick.bind(this);
     this.handleDecreaseClick = this.handleDecreaseClick.bind(this);

    }
    ///2)
     handleIncreaseClick(){
        
        console.log("Handle click INCREASE=> counter is now ---->" + this.state.count);
        var currentCount = this.state.count;
        currentCount = currentCount +1;
        //this.setState({count:1});

        console.log(currentCount);
        this.setState({count:currentCount});

     }

     handleDecreaseClick(){
       console.log("Handle click DECREASEe=> counter is now ---->" + this.state.count);
      var currentCount = this.state.count;
       currentCount = currentCount -1;
        //this.setState({count:1});

        console.log(currentCount);
        this.setState({count:currentCount});


       
     }

   
    
     render() {
       
       return <div><
          div><button onClick={this.handleIncreaseClick}>
       Increase +
     </button></div>
     <div><button onClick={this.handleDecreaseClick}>
       Increase -
     </button></div>
     <div>{this.state.count}</div></div>;
     }
     
     
     }

  ReactDOM.render(
    <Counter />,
    document.getElementById('root')
  );
