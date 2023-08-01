import http from './axios-common';


export function getAllDogs() {
    return http.get("/dogs");

}

export function saveDog(dog) {
    return http.post("/dogs", dog);

}

export function getOwner(dog) {
    return http.get( '/owner/${dog.id}');
}