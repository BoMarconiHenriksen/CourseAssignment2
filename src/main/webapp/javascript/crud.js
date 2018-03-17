
document.getElementById("btncrud").addEventListener("click", getUserInput);
document.getElementById("crud").addEventListener("change", changeInputFields);

function changeInputFields() {

    let changeSelection = document.getElementById("crud").value;

    if (changeSelection === "updatePerson") {
        const htmlInputField = ` <p>If there is a part you dont want to cange let the input field be empty</p>
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
    } else if (changeSelection === "deletePerson") {
        const htmlInputField = ``
        document.getElementById("showcrud").innerHTML = htmlInputField;
    } else if(changeSelection === "newPerson") {
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

}

function getUserInput() {

    //Get user choice
    //showInput bruges til getAll requests
    let ShowInput = document.getElementById("crud").value;

    //userInput bruges til at fange brguernes input
    userInput = document.getElementById("userInputCrud").value;

    if (ShowInput === "Update Person") {

    }


}

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

