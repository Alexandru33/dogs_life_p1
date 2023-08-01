import React from 'react'
import images from '../index'
import Card from 'react-bootstrap/Card'
import Button from 'react-bootstrap/Button'
import { useState } from 'react';
import Row from 'react-bootstrap/Row'
import Col from 'react-bootstrap/Col'





const DogDetail = (props ) => {

  const[counter, setCounter] = useState(0);


  return (
    <Card >

    <Card.Body >
      <Card.Title >Name: {props.info.name}</Card.Title>
      <Card.Text >Age: {props.info.age}</Card.Text>
      
      
      <Row>
        <Col><Button variant="primary">Show owner</Button></Col>
        <Col><Card.Text >Likes: {counter}</Card.Text > </Col>
      </Row>
      
    
    </Card.Body>
  </Card>
  )
}

export default DogDetail