     // --------------- Basic Navigations----------------
// import React, {Component} from 'react';
// import {BrowserRouter, Route, Switch} from "react-router-dom";

// import Home from "./basicComponents/Home"
// import Contact from "./basicComponents/contact"
// import Login from "./basicComponents/loginpage"
// import Error from "./basicComponents/Error"
// import Navigation from "./basicComponents/Navigation"

// class Reactrouter extends Component{
//     render(){
//         return(
//             <BrowserRouter> 
//             <div> 
//             <Navigation/>
//             <Switch>           
//             <Route path="/" component={Home} exact/>
//             <Route path="/contact" component={Contact}/>
//             <Route path="/loginpage" component={Login}/>
//             <Route component={Error}/>
//             </Switch>
// </div>
//             </BrowserRouter>
//         );
//     }
// }
// export default Reactrouter;

//        ---------------------------- Search Product By name Code------------------------------


//------------------------- Sales Graph--------------------------
//import './App.css';
import Chart from './components/chart';
import React,{ Component } from 'react';

class App extends Component{
     constructor(){
          super();
          this.state={
               charData: {}
          }
     }
componentWillMount(){
     this.getChartData();
}
     getChartData(){
          //Ajax Calls Here
          this.setState({
               charData:{
                labels:['Crocin', 'Dolo', 'Paracetemol','CarvolPlus', 'Chestoncold', 'Ocacet', 'Cold Total', 'ColdAct', 'HCQS', 'Thyronym', 'GemCal'],
                datasets:[{
               label:'NumberOfProductSold',
               data:[200,5,159,20,10,50,55,88,50,55,88],
               backgroundColor:[
                    'rgba(255,99,132,0.6)',
                    'rgba(54,162,235,0.6)',
                    'rgba(255,206,86,0.6)',
                    'rgba(75,192,192,0.6)',
                    'rgba(153,102,255,0.6)',
                     'rgba(510,159,64,0.6)',
                      'rgba(75,163,55,0.6)',
                    'rgba(123,45,67,0.6)',
               'rgba(987,65,43,0.6)',
          'rgba(456,98,25,0.6)',
     'rgba(147,54,23,0.6)'],
                      borderWidth:1, 
                      borderColor:'#777',
                      hoverBorderWidth:3,
                      hoverBorderColor:'#000'
                }]
            }
          })
     }
     render(){
          return(
               <div className="App">
                    <div className="App-header">
                         
                    </div>
<Chart chartData={this.state.charData} time="Weekly" legendPosition="bottom"/>
               </div>
          );
     }
}
export default App;