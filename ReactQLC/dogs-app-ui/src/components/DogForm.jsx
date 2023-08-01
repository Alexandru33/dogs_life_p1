import React from 'react'
import Form from 'react-bootstrap/Form'
import Row from 'react-bootstrap/Row'
import Button from 'react-bootstrap/Button'
import { useState} from 'react'
import { saveDog } from '../services/dogs-service'
import { useNavigate } from 'react-router-dom'



const DogForm = () => {

const [name, setName] = useState('');
const [age, setAge] = useState('');
const [owner, setOwner] = useState(0);


const handleNameChange = (event)=>{
    setName(event.target.value);
}

const handleAgeChange = (event)=>{
    setAge(event.target.value)
}

const handleOwnerChange = (event)=>{
    setOwner(event.target.value)
}

const navigate = useNavigate();
const handleSubmit =(event)=>{
    event.preventDefault();  
    
    let dog = {};
    dog.name = name;
    dog.age = age;
    dog.owner = owner;

    saveHero(hero)
   .then(res => {
      setName('');
      setAge('');
      setOwner('');
    
      navigate("/")
      })
    .catch(err=>{
       console.log(err);
      })   
}






  return (
    <Row className='dogForm'> 
        <Form>
        
            <Form.Group className="mb-3" controlId="name">
                <Form.Label>Dog Name: </Form.Label>
                <Form.Control type="text" placeholder="Dog name" value={name}
                    onChange={handleNameChange} />
            </Form.Group>
            <Form.Group className="mb-3" controlId="age">
                <Form.Label>Dog Age: </Form.Label>
                <Form.Control type="text" placeholder="Dog age" value={age}
                    onChange={handleAgeChange} />
            </Form.Group>
            <Form.Select aria-label="Owner ID"  value={owner}
                onChange={handleOwnerChange}>
                <option>Owner ID</option>
                <option value="1">One</option>
                <option value="2">Two</option>
                <option value="3">Three</option>
            </Form.Select>
            <Button variant="primary" type="submit" onClick={handleSubmit} >
                Submit
            </Button>
      </Form>
      </Row>
  )
}

export default DogForm