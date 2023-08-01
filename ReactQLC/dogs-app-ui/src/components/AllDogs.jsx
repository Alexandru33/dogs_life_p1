import React from 'react'
import DogDetail from './DogDetail'
import Row from 'react-bootstrap/Row'
import { useState, useEffect} from 'react'
import { getAllDogs } from '../services/hero-service'

const AllHeroes = () => {

  const [total, setTotal] = useState(0);



const [dogs,setDogs] = useState([]);

useEffect(()=>{
  getDogsFromAPI();}, 
  []
);

const getDogsFromAPI = ()=>{
  getAllDogs()
  .then(res => {
      setDogs(res.data);
  })
  .catch(err => {
      setDogs([]);
      console.log(err);
  })
}
    
        return (
          <>
          <h1> Total count is: {dogs.length}</h1>
            <Row >
              {dogs.map(dog => (
                  <div className='container' key={dog.id}>
                    <DogDetail info={dog}  />
                  </div>
                ))}
            </Row>
            
          </>
        )


    }

export default AllDogs