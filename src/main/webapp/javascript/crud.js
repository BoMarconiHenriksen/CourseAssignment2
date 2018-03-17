document.getElementById("btncrud").addEventListener("click", getUserInput);
document.getElementById("crud").addEventListener("change", changeInputFields);

function changeInputFields() {
    event.stopPropagation();
    let changeSelection = document.getElementById("crud").value;

    if (changeSelection === "updatePerson") {
        htmlUpdatePerson();
    } else if (changeSelection === "deletePerson") {
        const htmlInputField = ``
        document.getElementById("showcrud").innerHTML = htmlInputField;
    } else if (changeSelection === "newPerson") {
        htmlNewPerson();
    }

}

function getUserInput() {
    event.stopPropagation();
    //Get user choice
    //showInput bruges til getAll requests
    let ShowInput = document.getElementById("crud").value;
    console.log(ShowInput);
    //userInput bruges til at fange brguernes input
    var userInput = document.getElementById("userInputCrud").value;
    console.log(userInput);


    if (ShowInput === "updatePerson") {

        let id = document.getElementById("id").value;
        let newFirstName = document.getElementById("newFirstName").value;
        let newLastName = document.getElementById("newLastName").value;

        changeUser(id, newFirstName, newLastName);
    } else if (ShowInput === "newPerson") {

        let firstName = document.getElementById("newFirstName").value;
        let lastName = document.getElementById("newLastName").value;
        
        addUser(firstName, lastName);

    } else if(ShowInput === "deletePerson") {
        deleteUser(userInput);
    }


}

function addUser(firstName, lastName) {
    
    //clear the input fields
    document.getElementById("newFirstName").value = "";
    document.getElementById("newLastName").value = "";

//    document.getElementById("added").innerHTML = "The user was added.";

    var newUser = {
        firstName: firstName,
        lastName: lastName
    }

    var settings = {
        body: JSON.stringify(newUser), // must match 'Content-Type' header. Fra java object til json
        headers: {
            'content-type': 'application/json'
        },
        method: 'POST', // *GET, PUT, DELETE, etc.
    }

    fetch("https://benedikteeva.dk/CourseAssignment2-1.0-SNAPSHOT/api/persons", settings)
            .then(res => res.json()) //ta json resopnse og send det videre
//            .then(data => document.getElementById("name").innerText = data.name) //data er bare et navn

}

function deleteUser(userInput) {
//    let idDelete = document.getElementById("deleteIdUser").value;

    //clear the input fields
    document.getElementById("userInputCrud").value = "";

    let baseUrl = "https://benedikteeva.dk/CourseAssignment2-1.0-SNAPSHOT/api/persons/";
    let urlDelete = baseUrl + userInput;
    console.log(urlDelete);

    let settings = {
        body: JSON.stringify(), // must match 'Content-Type' header. Fra java object til json
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

                document.getElementById("added").innerHTML = "The user is deleted!";
            })
            .catch(error => {
                document.getElementById("error").innerText = error.message;
            });
}

function changeUser(id, newFirstName, newLastName) {
    console.log("changeuser");
    console.log(id);
    console.log(newFirstName);
    console.log(newLastName);

    let baseUrl = "https://benedikteeva.dk/CourseAssignment2-1.0-SNAPSHOT/api/persons/";

    let urlToFetch = baseUrl + id;

    //Find the user to change
    fetch(baseUrl)
            .then(response => {
                if (response.ok) {
                    return response.json();
                }
                throw new Error("Noget gik galt med fetch metoden!" + response.status.text);
            })
            .then(data => { //nu er data klar

                //Hvis feltet er tomt indsættes det som står i json filen.
                if (newFirstName == undefined || newFirstName === "") {
                    newFirstName = data.firstName;
                }

                //Hvis feltet er tomt indsættes det som står i json filen.
                if (newLastName === undefined || newLastName === "") {
                    newLastName = data.lastName;
                }

                //Hvis feltet er tomt indsættes det som står i json filen.
                let newUser = {
                    firstName: newFirstName,
                    lastName: newLastName
                }

                let settings = {
                    body: JSON.stringify(newUser), // must match 'Content-Type' header. Fra java object til json
                    headers: {
                        'content-type': 'application/json'
                    },
                    method: 'PUT', // *GET, PUT, DELETE, etc.
                }

                fetch(urlToFetch, settings)
                        .then(res => res.json()) //ta json resopnse og send det videre
//            .then(data => document.getElementById("name").innerText = data.name) //data er bare et navn


            })
            .catch(error => {
                document.getElementById("error").innerText = error.message;
            });

}

function htmlUpdatePerson() {
    const htmlInputField = ` <p>If there is a part you dont want to cange let the input field be empty</p>
                                <div class='inputs form-group' id="btns">
                                    <p>Enter Id: </p>
                                    <input id="id" placeholder='Add the person id' />
                                </div>
                                <div class='inputs form-group' id="btns">
                                    <p>Change Fisrt Name: </p>
                                    <input id="newFirstName" placeholder='Add new first name' />
                                </div>
                                <div class='inputs form-group' id="btns"> 
                                    <p>Change Last Name: </p>
                                    <input id="newLastName" placeholder='Add new last name' />
                                </div>
        `
    document.getElementById("showcrud").innerHTML = htmlInputField;
}

function htmlNewPerson() {
    const htmlInputField = ` <p>Enter the name and last name of the new person</p>
                                    <div class='inputs form-group' id="btns">
                                    <p>Enter Fisrt Name: </p>
                                    <input id="newFirstName" placeholder='Add first name' />
                                </div>
                                <div class='inputs form-group' id="btns"> 
                                    <p>Enter Last Name: </p>
                                    <input id="newLastName" placeholder='Add last name' />
                                </div>
        `
    document.getElementById("showcrud").innerHTML = htmlInputField;
}

