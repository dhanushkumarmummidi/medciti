import React from "react";

const initialState = {
  name: "",
  designation:"",
  email: "",
  password: "",
  nameError: "",
  designationError:"",
  emailError: "",
  passwordError: ""
};

export default class ValiationForm extends React.Component {
  state = initialState;

  handleChange = event => {
    const isCheckbox = event.target.type === "checkbox";
    this.setState({
      [event.target.name]: isCheckbox
        ? event.target.checked
        : event.target.value
    });
  };

  validate = () => {
    let nameError = "";
    let designationError ="";
    let emailError = "";
    // let passwordError = "";

    if (!this.state.name) {
      nameError = "name cannot be blank";
    }
     if (!this.state.designation) {
      designationError = "Designation cannot be blank";
    }

    if (!this.state.email.includes("@")) {
      emailError = "invalid email";
    }

    if (emailError || nameError || designationError) {
      this.setState({ designationError, emailError, nameError,  });
      return false;
    }

    return true;
  };

  handleSubmit = event => {
    event.preventDefault();
    const isValid = this.validate();
    if (isValid) {
      console.log(this.state);
      // clear form
      this.setState(initialState);
    }
  };

  render() {
    return (
      <form align="center" onSubmit={this.handleSubmit}>
        <div>
            <h1> New User??? Create an Account Here</h1>
          <input
            name="name"
            placeholder="Your name here"
            value={this.state.name}
            onChange={this.handleChange}
          />
          <div style={{ fontSize: 12, color: "red" }}>
            {this.state.nameError}
          </div>
        </div>

        <div>
          <input
            name="designation"
            placeholder="designation here"
            value={this.state.designation}
            onChange={this.handleChange}
          />
          <div style={{ fontSize: 12, color: "red" }}>
            {this.state.nameError}
          </div>
        </div>

        <div>
          <input
            name="email"
            placeholder="email"
            value={this.state.email}
            onChange={this.handleChange}
          />
          <div style={{ fontSize: 12, color: "red" }}>
            {this.state.emailError}
          </div>
        </div>
        <div>
          <input
            type="password"
            name="password"
            placeholder="password"
            value={this.state.password}
            onChange={this.handleChange}
          />
          <div style={{ fontSize: 12, color: "red" }}>
            {this.state.passwordError}
          </div>
        </div>
        <button type="submit">submit</button>
      </form>
    );
  }
}