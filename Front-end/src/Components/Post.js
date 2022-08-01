import { Component } from "react";
import { Container } from "react-bootstrap";


class Post extends Component{

    constructor(props){
        super(props);
        this.state = {
            items: [],
            detailsLoaded: false
        }
    }

    componentDidMount(){
        fetch("https://jsonplaceholder.typicode.com/users")
        .then((res)=>res.json())
        .then((json)=>{
            this.setState({
                items: json,
                detailsLoaded: true
            })
        })
    }

    render(){
        const {detailsLoaded,items}=this.state;
        if(!detailsLoaded) return (
            <>
                <Container>
                    <h2>Please wait loading</h2>
                </Container>
            </>
        );
        return (
            <>
                <h1>Fetch data from an api in react</h1>
                {items.map((item)=>(
                    <ol key={item.id}>
                        Username : {item.username}<br/>
                        Full name : {item.name}<br/>
                        Email : {item.email}
                    </ol>
                ))}
            </>
        );
    }
}

export default Post;