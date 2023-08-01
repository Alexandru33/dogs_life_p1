import React from 'react'
import images from '../index'
import Card from 'react-bootstrap/Card'
import Button from 'react-bootstrap/Button'
import { useState,useEffect } from 'react';
import Row from 'react-bootstrap/Row'
import Col from 'react-bootstrap/Col'
import { getOwner } from '../service/dogs-service'




const DogDetail = (props ) => {
  const [owner,setOwner] = useState('');
  const[counter, setCounter] = useState(0);
  useEffect(()=>{
    getDogFromAPI();}, 
    []
  );
 const [ok,setOk]=useState(false)
  
  const getDogFromAPI = (arg)=>{
    getOwner(arg)
    .then(res => {
        setOwner(res.data);
        console.log(res.data)
        setOk(true)
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
        <Col><Button variant="primary" onClick={()=>{getDogFromAPI(props.info.name)}}>Show owner</Button></Col>
        {ok==false}
        <><Col><Card.Text >Owner: {owner}</Card.Text > </Col></>
        :
        <>
        </>
        
      </Row>
      
    
    </Card.Body>
  </Card>
  )
}

export default DogDetail