function getSelectedOption(gender) {
    let option;
    let len = gender.options.length
    for(let i=0;i<len;i++) {
        option = gender.options[i];
        if (option.selected == true) {
            break;
        }
    }
    return option.value;
}

function isValid(first_name, last_name, age, gender, dob) {
    if (!first_name || !last_name || !age || !gender || !dob) {
        document.getElementById("alert").style.display = "block";
        return false;
    }
    return true;
}

class Student {
    constructor(first_name, last_name, age, gender, dob) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.age = age;
        this.gender = gender;
        this.dob = dob;
        this.addRollNo();
    }

    addRollNo() {
        let rollNo = Math.floor(Math.random() * 1001);
        this.rollNo = rollNo;
    }
}

function saveDetails() {
    document.getElementById("alert").style.display = "none";
    let first_name = document.getElementById("fName").value;
    let last_name = document.getElementById("lName").value;
    let age = document.getElementById("age").value;
    let gender = getSelectedOption(document.getElementById("gender"));
    let dob = document.getElementById("date").value;
    console.log(first_name);
    console.log(last_name);
    console.log(age);
    console.log(gender);
    console.log(dob);
    if (isValid(first_name, last_name, age, gender, dob)) {
        student = new Student(first_name, last_name, age, gender, dob);
        localStorage.setItem(student.rollNo, JSON.stringify(student));
        console.log(student.rollNo);
        document.getElementById("success").innerHTML = "Student Created Successfully with Roll No <b>" + student.rollNo + "</b>";
        document.getElementById("success").style.display = "block";
    }
}

function getDetails() {
    let rollNo = parseInt(document.getElementById("rollNo").value);
    console.log(rollNo);
    let student = JSON.parse(localStorage.getItem(rollNo));
    document.getElementById("rollNoDisplay").innerHTML = student.rollNo;
    document.getElementById("firstNameDisplay").innerHTML = student.first_name;
    document.getElementById("lastNameDisplay").innerHTML = student.last_name;
    document.getElementById("ageDisplay").innerHTML = student.age;
    document.getElementById("genderDisplay").innerHTML = student.gender;
    document.getElementById("dobDisplay").innerHTML = student.dob;
}