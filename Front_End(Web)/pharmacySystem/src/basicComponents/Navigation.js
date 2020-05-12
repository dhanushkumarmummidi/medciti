import React from "react";
import {NavLink} from "react-router-dom";

const Navigation=()=>{                  // Stateless Functional components
    return(
<div margin="5px" align="center">
    <NavLink to="/">  HOMEPAGE</NavLink> 
    <NavLink to="/loginpage">  LOGIN </NavLink>    
    <NavLink to="/contact">  CONTACT US</NavLink>
</div>
    );
};
export default Navigation;