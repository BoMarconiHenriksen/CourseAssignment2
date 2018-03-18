var userInput;


//submit.addEventListener("click", getInfo);
document.getElementById("btnsend").addEventListener("click", getData);


function getData() {

    //Get user choice
    //showAll bruges til getAll requests
    let ShowAll = document.getElementById("all").value;

    //getRequest bruges til specifikke requests
//    let getRequest = document.getElementById("request").value;

    //userInput bruges til at fange brguernes input
    userInput = document.getElementById("userInput").value;

    if (ShowAll === "Get All Persons") {
        fetchAllPersons();
    } else if (ShowAll === "Get Person By Id") {
        findSingleUser(userInput);
    }

//    if(getRequest === "Get Person By Id") {
//        findSingleUser(userInput);
//    }




}


//function findSingleUser(userInput) {
//
//
//    let baseUrl = "https://benedikteeva.dk/CourseAssignment2-1.0-SNAPSHOT/api/persons/";
//
//
//    let url = baseUrl + userInput;
//    console.log(url);
//    fetch(url)
//            .then(response => {
//                if (response.ok) {
//               console.log(response)
//                            .then(data => { //nu er data klar
//                                console.log(data);
//
//
//                                const urows = data.map(user => `<tr>
//                                                <td>${user.personId}</td>
//                                                <td>${user.firstName}</td>
//                                                <td>${user.lastName}</td></tr>`).join("\n");
//                                //Her laves det som skal udskrives på htmlsiden                                
//                                const uhtmlTable = `<table class="table">
//                    <thead>
//                        <tr>
//                            <th>Person Id</th>
//                            <th>First Name</th>
//                            <th>Last Name</th>
//                        </tr>
//                    </thead
//                    <tbody>
//                    ${urows}
//                    </tbody>
//                </table>
//                `
//
//                                document.getElementById("table").innerHTML = uhtmlTable;
//
//                            })
//                            
//                }
//                   else {
//                    console.log(response.json())
//                            .then(data => { //nu er data klar
//                                console.log("data" + data);
//                                const erows = data.map(errorMessage => `<tr>
//                                                <td>${errorMessage.code}</td>
//                                                <td>${errorMessage.message}</td>
//                                                <td>${errorMessage.description}</td></tr>`).join("\n");
//                                //Her laves det som skal udskrives på htmlsiden                                
//                                const ehtmlTable = `<table class="table">
//                    <thead>
//                        <tr>
//                            <th>code</th>
//                            <th>message</th>
//                            <th>description</th>
//                        </tr>
//                    </thead
//                    <tbody>
//                    ${erows}
//                    </tbody>
//                </table>
//        `
//                                document.getElementById("table").innerHTML = ehtmlTable;
//                                
//                            })
//
//
//            };
//        })};
        
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
                    return response.jason;
                }
                throw new Error("Noget gik galt med fetch metoden!" + response.text());
            })
            .then(data => { //nu er data klar

                //Hvis feltet er tomt indsættes det som står i json filen.
                if (newFirstName === undefined || newFirstName === "") {
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
                };

                let settings = {
                    body: JSON.stringify(newUser), // must match 'Content-Type' header. Fra java object til json
                    headers: {
                        'content-type': 'application/json',
                        'accept': 'application/json'
                       
                    },
                    method: 'PUT', // *GET, PUT, DELETE, etc.
                }

                fetch(urlToFetch, settings)
                        .then(res => res.json) //ta json resopnse og send det videre
            .then(data => document.getElementById("name").innerHTML ="Person with id no:  "+id+"  now has data:  FirstName: "+ newFirstName+" LastName: "+newLastName); //data er bare et navn


            })
            .catch(error => {
                document.getElementById("error").innerText = error.message;
            });

}

    function fetchAllInfoEntities() {


        fetch("https://benedikteeva.dk/CourseAssignment2-1.0-SNAPSHOT/api/ies/") //returner objekt som promise

                .then(response => {
                    if (response.ok) {
                        return response.json();
                    }
                    throw new Error("Noget gik galt med fetch metoden!" + response.status.text);
                    console.log(response.json());
                    return response.json();

                })
                .then(data => { //nu er data klar
                    //Laver rækken
                    const irows = data.map(ies => `<tr>
                                                <td>${ies.id}</td>
                                                <td>${ies.email}</td>
                                                <td>${ies.address}</td></tr>`).join("\n");
                    //Her laves det som skal udskrives på htmlsiden                                
                    const ihtmlTable = `<table class="table">
                    <thead>
                        <tr>
                            <th>Id</th>
                            <th>Email</th>
                            <th>Address</th>
                        </tr>
                    </thead
                    <tbody>
                    ${irows}
                    </tbody>
                </table>
        `
                    document.getElementById("table").innerHTML = ihtmlTable;
                })
                .catch(error => {
                    document.getElementById("error").innerText = error.message;
                });

    }
