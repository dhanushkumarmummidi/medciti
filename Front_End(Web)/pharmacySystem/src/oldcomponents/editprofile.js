import React from 'react';
///import {Table, Button} from 'react-bootstrap';

class editprofile extends React.Component {
    constructor(props){
        super(props);
        this.state={
            error:null,
            profile:[]
        };
    }
    componentDidMount(){
        const apiUrl = "http://dummy.restapiexample.com/api/v1/employees";

        fetch(apiUrl)
        .then(res => res.json())
        .then(
            (result) =>{
                this.setState({
                    profile: result
                })
            },
            (error)=>{
                this.setState({error})
            }
        )
    }
    render() {
        const {error,profile} = this.state;
        if(error){
            return(
            <div> Error :  {error.message} </div>
             )
        }
        else{
            return(
                <div> 
                    <h2> My Profile</h2>
            <label type="text"> Name :</label> <input type="text">{profile.name} </input>
            <label type="text"> Email : </label> <input type="text">{profile.email} </input>
            <label type="text"> Designation : </label> <input type="text">{profile.designation}</input>
            <label type="text"> Location Id : </label> <input type="text">{profile.locationid}</input>
            <button type="submit"> Update Info </button>

                </div>
            )
        }
    }
}

export default editprofile;