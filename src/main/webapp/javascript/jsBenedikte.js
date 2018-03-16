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

    if (ShowAll === "Get All Persons") {
        fetchAllPersons();
    } else if (ShowAll === "Get Person By Id") {
        findSingleUser(userInput);
    }

//    if(getRequest === "Get Person By Id") {
//        findSingleUser(userInput);
//    }




}


function findSingleUser(userInput) {
    
    

    let baseUrl = "http://localhost:8080/CourseAssignment2/api/persons/";

    let url = baseUrl + userInput;
    console.log(url);
    fetch(url)
            .then(response => {
               
            })
            .then(data => { //nu er data klar
                console.log(data);
            

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
            .then(data => { 
                 const erows = data.map(error => `<tr>
                                                <td>${error.code}</td>
                                                <td>${error.message}</td>
                                                <td>${error.description}</td></tr>`).join("\n");
                //Her laves det som skal udskrives på htmlsiden                                
                const ehtmlTable = `<table class="table">
                    <thead>
                        <tr>
                            <th>code</th>
                            <th>message</th>
                            <th>description</th>
                        </tr>
                    </thead
                    <tbody>
                    ${erows}
                    </tbody>
                </table>
                `
                
                document.getElementById("error").innerText = ehtmlTable;
            }  )};


//OPG DELETE AN EXISTING USER
//document.getElementById("deleteUser").addEventListener("click", deleteUser);

