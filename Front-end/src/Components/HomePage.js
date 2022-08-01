import { Component } from "react";
import Characters from "./Characters";
import Footer from "./Footer";

class HomePage extends Component {

  constructor(props){
    super(props);
    this.state = {
      isLoaded: false,
    }
  }

  handleCallBack = (data) => {
    this.setState({isLoaded: data});
  }

  render() {
    return (
      <>
        <Characters
          title="Characters"
          url="http://localhost:8080/api/characters"
          parentCallback = {this.handleCallBack}
        />
        <hr/>
        <Characters
          title="Summoning Animals"
          url="http://localhost:8080/api/animals"
          parentCallback = {this.handleCallBack}
        />
        {
          this.state.isLoaded?<Footer />:null
        }
      </>
    );
  }
}

export default HomePage;
