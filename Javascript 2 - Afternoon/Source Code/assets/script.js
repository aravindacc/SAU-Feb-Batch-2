let students = {};
let lastRollNo = 0;


class Student {
  constructor(firstName, lastName, age, gender, dob, email) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.age = age;
    this.gender = gender;
    this.email = email;
    this.dob = dob;
    this.assignRollNo();
  }

  assignRollNo() {
    this.rollNo = "171B" + (lastRollNo);
  }
}


function getRollNo() {
  ++lastRollNo;
  document.getElementById("rollNo").value = lastRollNo;
}


function validateEntry() {

  let firstName = document.getElementById("f_name").value;
  let lastName = document.getElementById("l_name").value;
  let dob = document.getElementById("dob").value;
  let age = document.getElementById("age").value;
  let gender = document.getElementById("gender").value;
  let email = document.getElementById("email").value;
  let c_me = $("#c_me").is(':checked');

  console.log(c_me)
  let res = true;
  const elements = document.querySelectorAll('.invalid-feedback');
  Array.from(elements).forEach((element, index) => {
    $(element).removeClass("show")
  });

  if (firstName === "") {
    let element = document.getElementById("f_name").parentElement;
    $(element).find("div").addClass("show")
    res = false;
  }
  if (email === "" || /^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\.[a-zA-Z0-9-]+)*$/.test(email) === false) {
    let element = document.getElementById("email").parentElement;
    $(element).find("div").addClass("show")
    res = false;
  }
  if (lastName === "") {
    let element = document.getElementById("l_name").parentElement;
    $(element).find("div").addClass("show")
    res = false;
  }
  if (dob === "") {
    let element = document.getElementById("dob").parentElement;
    $(element).find("div").addClass("show")
    res = false;
  }

  if (gender === "") {
    let element = document.getElementById("gender").parentElement;
    $(element).find("div").addClass("show")
    res = false;
  }
  if (age === "") {
    let element = document.getElementById("age").parentElement;
    $(element).find("div").addClass("show")
    res = false;
  }

  if (c_me === false) {
    let element = document.getElementById("c_me").parentElement;
    $(element).find("div").addClass("show")
    res = false;
  }
  return res;
}


function createStudent() {
  if (validateEntry() === false) {
    return;
  }
  const elements = document.querySelectorAll('.invalid-feedback');


  let firstName = document.getElementById("f_name").value;
  let lastName = document.getElementById("l_name").value;
  let dob = document.getElementById("dob").value;
  let age = document.getElementById("age").value;
  let gender = document.getElementById("gender").value;
  let rollNo = document.getElementById("rollNo").value;
  if (rollNo in students) {
    alert("Student With RollNo. Already Exists In the Database");
  }
  else {
    students[rollNo] = new Student(firstName, lastName, age, gender, dob);
    getRollNo();
    document.getElementById("data_table").innerHTML += `<tr>
    <th scope="row">171B`+ rollNo + `</th>
    <td>`+ firstName + `</td>
    <td>`+ lastName + `</td>
    <td>`+ age + `</td>
    <td>`+ gender + `</td>
    <td>`+ dob + `</td>
  </tr>`
  }
}


function searchStudent() {
  document.getElementById("myTerminal").innerHTML = "";
  let student = getStudent();
  if (student) {
    document.getElementById("myTerminal").innerHTML += `<p><span class="terminalOutput">&nbsp;&nbsp;<b>></b>&nbsp;&nbsp;<b>First Name: ` + student.firstName + `</span><span class="terminalOutput">&nbsp;|&nbsp;&nbsp;<b>Last Name: ` + student.lastName + `</span></p>`;
    document.getElementById("myTerminal").innerHTML += `<p><span class="terminalOutput">&nbsp;&nbsp;<b>></b>&nbsp;&nbsp;<b>Email: ` + student.email + `</span><span class="terminalOutput">&nbsp;|&nbsp;&nbsp;<b>Age: ` + student.age + `</span><span class="terminalOutput">&nbsp;|&nbsp;&nbsp;<b>Gender: ` + student.gender + `</span></p>`;
    document.getElementById("myTerminal").innerHTML += `<p><span class="terminalOutput">&nbsp;&nbsp;<b>></b>&nbsp;&nbsp;<b>Roll Number: ` + student.rollNo + `</span></p>`;

    document.getElementById("myTerminal").innerHTML += `<p class="terminalOutput"><b>&nbsp;&nbsp;<b>></b>&nbsp;&nbsp;Object Tree: </b></p><textarea disabled id="terminalOutput" style="margin-left: 20px;
    font-size: 1.0rem; background-color: black; color:white;" cols="30" rows="8">
`+ JSON.stringify(student, null, 4) +
      `</textarea>`

  }
}


function getStudent() {
  let rollNo = document.getElementById("findRollNo").value;
  if (rollNo in students) {
    return students[rollNo];
  }
  alert("No Student With RollNo. Exists In the Database");
}