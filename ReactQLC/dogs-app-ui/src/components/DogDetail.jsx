import React from 'react'
import images from '../index'
import Card from 'react-bootstrap/Card'
import Button from 'react-bootstrap/Button'
import { useState,useEffect } from 'react';
import Row from 'react-bootstrap/Row'
import Col from 'react-bootstrap/Col'
import { getOwner } from '../service/dogs-service'




const DogDetail = (props ) => {
  const [owner,setOwner] = useState([]);
  const[counter, setCounter] = useState(0);
  useEffect(()=>{
    getDogFromAPI();}, 
    []
  );
  
  const getDogFromAPI = ()=>{
    getOwner(props.info.name)
    .then(res => {
        setOwner(res.data);
    })
    .catch(err => {
        
        console.log(err);
    })
  }

  return (
    <Card >

    <Card.Body >
      <Card.Title >Name: {props.info.name}</Card.Title>
      <Card.Text >Age: {props.info.age}</Card.Text>
      
      
      <Row>
        <Col><Button variant="primary" onClick={getDogFromAPI}>Show owner</Button></Col>
        <Col><Card.Text >Owner: {owner}</Card.Text > </Col>
      </Row>
      
    
    </Card.Body>
  </Card>
  )
}

export default DogDetail