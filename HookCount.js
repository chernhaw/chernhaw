import React, {useState} from 'react';

function Example() {
  const [count, setCount]=useState(0);

  return (
    <div>

      <p>You clicked {count} times</p>
      <button onClick={
        ()=> setCount(count+1)

      }>
          Click me to increase
      </button>
      <button onClick={
        ()=> setCount(count-1)

      }>
          Click me to decrease
      </button>
      <button onClick ={
           ()=> setCount(count-count)
      }>
        Reset Counter
      </button>
    </div>
  );
}

 ReactDOM.render(
  <Example />,
  document.getElementById('root')
);
