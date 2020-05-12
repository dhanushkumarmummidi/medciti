//  Fetching the data

 import React, { Component } from 'react';

 class superAdmin extends Component{

   constructor(props){
    super(props);
// // // Setting Initial State
     this.state={
       data: [],
     status:"",
     };
   }
a
   componentDidMount(){
     fetch('http://dummy.restapiexample.com/api/v1/employees')
     .then(res =>res.json())
     .then(json => {
 this.setState({           // getting the data and saving the data into the state.
   status:"success",
   data: json,

 })
     });
   }

   render(){ 
     const mystyle = {
       color: "black",
       padding: "10px",
       fontFamily: "arial, sans-serif",
       border: "5px solid #dddddd",
       width:"50%",
      
         };

     var {status,data} = this.state;
     if(!status){
       return <div> Loading... Please Wait </div>
     }     
     else{
       data = data.data;
 return(
       <div className="App">
     <table style={mystyle}>
       <thead>
         <tr>
           <th> Name</th>
           <th> Salary</th>
           <th> Age</th>
         </tr>
         </thead>
           
  {data.map((d,ind )=> (
       <tbody>
                <tr>
           <td > {d.id} </td>
           <td > {d.name} </td>
           <td > {d.designation} </td>
         </tr>
       </tbody>
        )) };
     </table>
   

       </div>
    );
    }         // ComponentDidmount() Runs after the Render() Method.
    
  }
 }
export default superAdmin;

