import React from 'react';
import ReactDOM from 'react-dom';
import {useForm} from "react-hook-form";
import './board.css';
import './App.css';

export default function AppForm2(){
  const {register, handleSubmit, formState} = useForm();
   React.useEffect(() => {console.log("category", formState.category);
}, [formState]);

  const onSubmit = (data) => console.log(data);

  return (
    <form onSubmit = {handleSubmit(onSubmit)}>
      <input {...register("firstName", {required: true})} placeholder="First name" />
      <input {...register("lastName", {minLength:2 })} placeholder="Last name"/>
      <select {...register("category")}>
        <option value ="A">Category A </option>
        <option value ="B">Category B </option>
        <option value ="B1">Category B1 </option>
      </select>
      <input type="submit"/>
    </form>
  );
}

ReactDOM.render(
       <AppForm2 />,
   document.getElementById('root')
 );
