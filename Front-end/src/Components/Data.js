import { useState } from "react";
import { Alert, Button, Col, Container, Form, Row } from "react-bootstrap";

export default function Data() {
  const [name, setName] = useState("");
  const [affiliation, setAffiliation] = useState("");
  const [rank, setRank] = useState("");
  const [species, setSpecies] = useState("");
  const [imageUrl, setImageUrl] = useState("");
  const [status, setStatus] = useState("");
  const [message, setMessage] = useState("");
  const [alertType, setAlertType] = useState("");

  let handleSubmit = async (e) => {
    e.preventDefault();
    try {
      let res = await fetch("http://localhost:8080/api/addNew", {
        method: "PUT",
        body: JSON.stringify({
          name: name,
          affiliation: affiliation,
          rank: rank,
          species: species,
          imageUrl: imageUrl,
          status: status,
        }),
        headers: {
          "Content-Type": "application/json",
        },
      });
      if (res.status === 200) {
        setName("");
        setAffiliation("");
        setRank("");
        setSpecies("");
        setStatus("");
        setImageUrl("");
        setAlertType("success");
        setMessage("Data created successfully");
      } else {
        setAlertType("warning");
        setMessage("Some error occured");
      }
    } catch (err) {
      console.log(err);
    }
  };

  return (
    <>
      <br />
      <Container>
        {message ? (
          <Alert key={alertType} variant={alertType}>
            <h3 className="text-left">{message}</h3>
          </Alert>
        ) : (
          <></>
        )}
        <h1 className="text-left">Add Data here</h1>
        <br />
        <Form onSubmit={handleSubmit}>
          <Form.Group className="mb-3">
            <Form.Control
              type="text"
              value={name}
              onChange={(e) => setName(e.target.value)}
              placeholder="Name"
              required
            />
          </Form.Group>

          <Row>
            <Col md>
              <Form.Group className="mb-3">
                <Form.Control
                  type="text"
                  value={status}
                  onChange={(e) => setStatus(e.target.value)}
                  placeholder="Status"
                  required
                />
              </Form.Group>
            </Col>
            <Col md>
              <Form.Group className="mb-3">
                <Form.Control
                  type="text"
                  value={rank}
                  onChange={(e) => setRank(e.target.value)}
                  placeholder="Rank"
                  required
                />
              </Form.Group>
            </Col>
            <Col md>
              <Form.Group className="mb-3">
                <Form.Control
                  type="text"
                  value={species}
                  onChange={(e) => setSpecies(e.target.value)}
                  placeholder="Species"
                  required
                />
              </Form.Group>
            </Col>
          </Row>

          <Form.Group className="mb-3">
            <Form.Control
              type="imageUrl"
              value={imageUrl}
              onChange={(e) => setImageUrl(e.target.value)}
              placeholder="Image Url"
              required
            />
          </Form.Group>

          <Form.Group className="mb-3">
            <Form.Control
              type="text"
              value={affiliation}
              onChange={(e) => setAffiliation(e.target.value)}
              placeholder="Affiliation"
              required
            />
          </Form.Group>
          
          <Button
            className="mb-3 d-flex justify-content-start"
            variant="primary"
            type="submit"
          >
            Submit
          </Button>
        </Form>
      </Container>
    </>
  );
}
