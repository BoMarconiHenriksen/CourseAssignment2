var userInput;

document.getElementById("btnsend").addEventListener("click", getData);

function getData() {

    //Get user choice
    //showAll bruges til getAll requests
    let ShowAll = document.getElementById("all").value;

    //userInput bruges til at fange brguernes input
    userInput = document.getElementById("userInput").value;

    if (ShowAll === "Get All Persons") {
        fetchAllPersons();
    } else if (ShowAll === "Get Person By Id") {
        findSingleUser(userInput);
    } else if(ShowAll === "Get All Companies") {
        fetchAllCompanies();
    }


}

//show users
function fetchAllPersons() {

    fetch("https://benedikteeva.dk/CourseAssignment2-1.0-SNAPSHOT/api/persons") //returner objekt som promise
            .then(response => {
                if (response.ok) {
                    return response.json();
                }
                throw new Error("Noget gik galt med fetch metoden!" + response.status.text);
      console.log(response.json());
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

function fetchAllCompanies()  {
    fetch("https://benedikteeva.dk/CourseAssignment2-1.0-SNAPSHOT/api/companies") //returner objekt som promise
            .then(response => {
                if (response.ok) {
                    return response.json();
                }
                throw new Error("Noget gik galt med fetch metoden!" + response.status.text);
            })
            .then(data => { //nu er data klar
                //Laver rækken
                const rows = data.map(companies => `<tr>
                                                <td>${companies.name}</td>
                                                <td>${companies.description}</td>
                                                <td>${companies.marketValue}</td></tr>`).join("\n");
                //Her laves det som skal udskrives på htmlsiden                                
                const htmlTable = `<table class="table">
                    <thead>
                        <tr>
                            <th>Name</th>
                            <th>Dscription</th>
                            <th>Market Value</th>
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

function findSingleUser(userInput) {

    let baseUrl = "https://benedikteeva.dk/CourseAssignment2-1.0-SNAPSHOT/api/persons/";

    let url = baseUrl + userInput;
    console.log(url);
    fetch(url)
            .then(response => {
                if (response.ok) {
                    return response.json();
                }
                console.log(response.json());
                throw new Error("Der er ikke noget person med de søgekriterier!");
            })
            .then(data => { //nu er data klar
                console.log(data);
                console.log(data.firstName);

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
