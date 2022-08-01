import { Component } from "react";
import { Card, Col, Container, Row } from "react-bootstrap";
import LoadingScreen from "./LoadingScreen";
import CardBody from "./CardBody";

class Characters extends Component {
  constructor(props) {
    super(props);
    this.state = {
      items: [],
      url: props.url,
      detailsLoaded: false,
      title: props.title,
    };
  }

  componentDidMount() {
    fetch(this.state.url)
      .then((res) => res.json())
      .then((json) => {
        this.setState({
          items: json,
          detailsLoaded: true,
        });
        this.props.parentCallback(this.state.detailsLoaded)
      });
  }

  render() {
    const { detailsLoaded, items } = this.state;
    let characterBodyStyle = {
      height: "27rem",
    };
    let summoningAnimalStyle = {
      height: "25rem",
    };
    if (!detailsLoaded) {
      return (
        <>
          <Container>
            <LoadingScreen />
          </Container>
        </>
      );
    } else {
      return (
        <>
          <br />
          <h2 className="title">{this.state.title}</h2>
          <br />
          <Container fluid>
            <Row>
              {items.map((item) => (
                <Col key={item.id} className="ml-2">
                  <Card style={{ width: "20rem" }}>
                    <Card.Img variant="top" src={item.imageUrl} height="320" />
                    <Card.Body
                      style={
                        this.state.title === "Characters"
                          ? characterBodyStyle
                          : summoningAnimalStyle
                      }
                    >
                      <Card.Title>{item.name}</Card.Title>
                      <div className="card-text">
                        {this.state.title === "Characters" ? (
                          <Row>
                            <CardBody
                              text="Affiliation"
                              value={item.affiliation.split(",").join(" | ")}
                            />
                            <CardBody text="Status" value={item.status} />
                            <CardBody text="Rank" value={item.rank} />
                          </Row>
                        ) : (
                          <Row>
                            <CardBody
                              text="Summoner"
                              value={item.summoner.split(",").join(" | ")}
                            />
                            <CardBody
                              text="Allies"
                              value={item.allies.split(",").join(" | ")}
                            />
                          </Row>
                        )}
                      </div>
                    </Card.Body>
                  </Card>
                </Col>
              ))}
            </Row>
          </Container>
        </>
      );
    }
  }
}

export default Characters;
