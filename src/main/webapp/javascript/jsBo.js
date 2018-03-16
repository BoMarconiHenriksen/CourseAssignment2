var userInput;


//submit.addEventListener("click", getInfo);
document.getElementById("btnsend").addEventListener("click", getData);
//btnsql.addEventListener("click", makeSql);

function getData() {
    
    //Get user choice
    //showAll bruges til getAll requests
    let ShowAll = document.getElementById("all").value;
    
    //getRequest bruges til specifikke requests
//    let getRequest = document.getElementById("request").value;
    
    //userInput bruges til at fange brguernes input
    userInput = document.getElementById("userInput").value;
    
    if(ShowAll === "Get All Persons") {
        fetchAllPersons();
    } else if(ShowAll === "Get Person By Id") {
        findSingleUser(userInput);
    }
    
//    if(getRequest === "Get Person By Id") {
//        findSingleUser(userInput);
//    }
    
    
    
    
}

//show users
function fetchAllPersons() {

    fetch("http://localhost:8084/CourseAssignment2/api/persons") //returner objekt som promise
            .then(response => {
                if (response.ok) {
                    return response.json();
                }
                throw new Error("Noget gik galt med fetch metoden!" + response.status.text);
            })
            .then(data => { //nu er data klar
                //Laver rækken
                const rows = data.map(user => `<tr>
                                                <td>${user.personId}</td>
                                                <td>${user.firstName}</td>
                                                <td>${user.lastName}</td></tr>`).join("\n");
                //Her laves det som skal udskrives på htmlsiden                                
                const htmlTable = `<table class="table">
                    <thead>
                        <tr>
                            <th>Person Id</th>
                            <th>First Name</th>
                            <th>Last Name</th>
                        </tr>
                    </thead
                    <tbody>
                    ${rows}
                    </tbody>
                </table>
        `
                document.getElementById("table").innerHTML = htmlTable;
            })
            .catch(error => {
                document.getElementById("error").innerText = error.message;
            });

}

//OPG ADD A NEW USER
document.getElementById("newUser").addEventListener("click", addUser);

function addUser() {

    //Henter info fra input felterne
    let name = document.getElementById("name").value;
    let age = document.getElementById("age").value;
    let gender = document.getElementById("gender").value;
    let email = document.getElementById("email").value;

    //clear the input fields
    document.getElementById("name").value = "";
    document.getElementById("age").value = "";
    document.getElementById("gender").value = "";
    document.getElementById("email").value = "";

    document.getElementById("added").innerHTML = "The user is added.";

    var newUser = {
        age: age,
        name: name,
        gender: gender,
        email: email
    }

    var settings = {
        body: JSON.stringify(newUser), // must match 'Content-Type' header. Fra java object til json
        headers: {
            'content-type': 'application/json'
        },
        method: 'POST', // *GET, PUT, DELETE, etc.
    }

    fetch("http://localhost:3000/users", settings)
            .then(res => res.json()) //ta json resopnse og send det videre
//            .then(data => document.getElementById("name").innerText = data.name) //data er bare et navn

}

function findSingleUser(userInput) {

    let baseUrl = "http://localhost:8084/CourseAssignment2/api/persons/";

    let url = baseUrl + userInput;
    console.log(url);
    fetch(url)
            .then(response => {
                if (response.ok) {
                    return response.json();
                }
                throw new Error("Noget gik galt med fetch metoden!" + response.status.text);
            })
            .then(data => { //nu er data klar

                //Udskriver brugeren
                var user = "id: "  + data.personId + "<br>"
                        + "Name: " + data.firstName + "<br>"
                        + "Age: " + data.lastName + "<br>"

                document.getElementById("table").innerHTML = user;
            })
            .catch(error => {
                document.getElementById("error").innerText = error.message;
            });
}

//OPG DELETE AN EXISTING USER
document.getElementById("deleteUser").addEventListener("click", deleteUser);

function deleteUser() {
    let idDelete = document.getElementById("deleteIdUser").value;

    //clear the input fields
    document.getElementById("deleteIdUser").value = "";

    let baseUrl = "http://localhost:3000/users/";

    let urlDelete = baseUrl + idDelete;

    let settings = {
        body: JSON.stringify(newUser), // must match 'Content-Type' header. Fra java object til json
        headers: {
            'content-type': 'application/json'
        },
        method: 'DELETE', // *GET, PUT, DELETE, etc.
    }

    fetch(urlDelete, settings)
            .then(response => {
                if (response.ok) {
                    return response.json(); //res.jason hvis det er json
                }
                throw new Error("Noget gik galt med fetch metoden!" + response.status.text);
            })
            .then(data => { //nu er data klar

                document.getElementById("userDeleted").innerHTML = "The user is deleted!";
            })
            .catch(error => {
                document.getElementById("error").innerText = error.message;
            });
}

//OPG EDIT AN EXISTING USER
document.getElementById("changeUSer").onclick = changeUser;

function changeUser() {
    let idChangedUser = document.getElementById("userId").value;
    let newName = document.getElementById("newName").value;
    let ageChange = document.getElementById("ageChange").value;
    let genderChange = document.getElementById("genderChange").value;
    let emailChange = document.getElementById("emailChange").value;

    let baseUrlFor = "http://localhost:3000/users/";

    let urlChange = baseUrlFor + idChangedUser;



    //Find the user to change
    fetch(urlChange)
            .then(response => {
                if (response.ok) {
                    return response.json();
                }
                throw new Error("Noget gik galt med fetch metoden!" + response.status.text);
            })
            .then(data => { //nu er data klar

                //Hvis feltet er tomt indsættes det som står i json filen.
                if (ageChange == undefined || ageChange === "") {
                    ageChange = data.age;
                }

                //Hvis feltet er tomt indsættes det som står i json filen.
                if (newName === undefined || newName === "") {
                    newName = data.name;
                }

                //Hvis feltet er tomt indsættes det som står i json filen.
                if (genderChange == undefined || genderChange === "") {
                    genderChange = data.gender;
                }

                //Hvis feltet er tomt indsættes det som står i json filen.
                if (emailChange == undefined || emailChange === "") {
                    emailChange = data.email;
                }

                //Hvis feltet er tomt indsættes det som står i json filen.
                let newUser = {
                    age: ageChange,
                    name: newName,
                    gender: genderChange,
                    email: emailChange
                }

                let settings = {
                    body: JSON.stringify(newUser), // must match 'Content-Type' header. Fra java object til json
                    headers: {
                        'content-type': 'application/json'
                    },
                    method: 'PUT', // *GET, PUT, DELETE, etc.
                }

                fetch(urlChange, settings)
                        .then(res => res.json()) //ta json resopnse og send det videre
//            .then(data => document.getElementById("name").innerText = data.name) //data er bare et navn


            })
            .catch(error => {
                document.getElementById("error").innerText = error.message;
            });

}


