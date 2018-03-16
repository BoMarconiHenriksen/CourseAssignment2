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
        checkInput(userInput);
        findSingleUser(userInput);
    }




}


//
//document.getElementById("btnsend").onerror=function(userinput){
//        
//    let baseUrl = "http://localhost:8080/CourseAssignment2/api/persons/";
//
//    let url = baseUrl + userInput;
//    console.log(url);
//    fetch(url)
//            .then(response => {
//           
//                    return response.json();
//               
//
//                
//              
//                //throw new Error("Noget gik galt med fetch metoden!" + response.status.text);
//            })
//            .then(data => { //nu er data klar
//              
//    let baseUrl = "http://localhost:8080/CourseAssignment2/api/persons/";
//
//    let url = baseUrl + userInput;
//    console.log(url);
//    fetch(url)
//            .then(response => {
//           
//                    return response.json();
//               
//
//                
//              
//                //throw new Error("Noget gik galt med fetch metoden!" + response.status.text);
//            })
//            .then(data => { //nu er data klar
//                console.log(data);
//                console.log(data.firstName);
//        
//
//                const errorrows = data.map(error => `<tr>
//                                                <td>${error.code}</td>
//                                                <td>${error.description}</td>
//                                                <td>${error.message}</td></tr>`).join("\n");
//                //Her laves det som skal udskrives på htmlsiden                                
//          
//            
//            const htmlTable = `<table class="table">
//                    <thead>
//                        <tr>
//                            <th>Code</th>
//                            <th>Description</th>
//                            <th>Message</th>
//                        </tr>
//                    </thead
//                    <tbody>
//                    ${rows}
//                    </tbody>
//                </table>`
//               
//
//                document.getElementById("table").innerHTML = htmlTable;
//                
//            })
//       
//
//            })
//            }
//        
//        



//show users
function fetchAllPersons() {

    fetch("http://localhost:8080/CourseAssignment2/api/persons") //returner objekt som promise
            .then(response => {
           
                response.json();
                
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
          

}
//OPG ADD A NEW USER
//document.getElementById("newUser").addEventListener("click", addUser);



function findSingleUser(userInput) {

    let baseUrl = "http://localhost:8080/CourseAssignment2/api/persons/";

    let url = baseUrl + userInput;
    console.log(url);
    fetch(url)
            .then(response => {
              if (response.ok) {
                    return response.json();
                }
                throw new Error("Noget gik galt med fetch metoden!" + response.json());
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
         
}







