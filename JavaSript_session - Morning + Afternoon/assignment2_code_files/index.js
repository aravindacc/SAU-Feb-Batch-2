
let arr = [];

// Function for storing the form data and performing form validation
function store() {
    
    let invalid = false;
    // FORM VALIDATION USING IIFE


    let Gender = "";
    (function () {
         // First Name
        if (document.getElementById("fname").value == "" || document.getElementById("fname").value == undefined) {
            alert("Enter the first name");
            invalid = true;
        }

        // Last Name
        if (document.getElementById("lname").value == "" || document.getElementById("lname").value == undefined) {
            alert("Enter the last name");
            //return false;
            invalid = true;
        }
        
        // Email
        if (!(/^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\.[a-zA-Z0-9-]+)*$/.test(document.getElementById("email").value)))
        {
            alert("Enter a valid email address");
            //return false;
            invalid = true;
        }

        // DOB
        if (document.getElementById("dob").value == "" || document.getElementById("dob").value == "")
        {
            alert("Enter a valid Date of Birth");
            //return false;
            invalid = true;
        }

        // Age
        if (document.getElementById("age").value == "" || document.getElementById("age").value == "")
        {
            alert("Enter your Age");
            //return false;
            invalid = true;
        }

        // ROll Number
        if (document.getElementById("rollNumber").value == "" || document.getElementById("rollNumber").value == "")
        {
            alert("Enter your RollNumber");
            //return false;
            invalid = true;
        }

        // Occupation
        if (document.getElementById("Occupation").value == "" || document.getElementById("Occupation").value == "")
        {
            alert("Enter your Occupation");
            //return false;
            invalid = true;
        }

        
        let ele = document.getElementsByName("gender");
        for (let i = 0; i<ele.length; i++) {
            if (ele[i].checked) {
                Gender = ele[i].value;
                break;
            }
        }    
    
        if (Gender == "" || Gender == undefined) {
            alert("Select the Gender");
            invalid = true;
        }

    }) ();

    // No entry will be recorded if the form is invalid
    if (invalid == true) {
        return;
    }


    // Recording form data in array of objects
    let studentobj = {};
    let fname = document.getElementById("fname").value;
    let lname = document.getElementById("lname").value;
    let email = document.getElementById("email").value;
    let age = document.getElementById("age").value;
    let RollNumber = document.getElementById("rollNumber").value;
    let occupation = document.getElementById("Occupation").value;
    let DOB = document.getElementById("dob").value;
    
    studentobj.Age = age;
    studentobj.DOB = DOB;
    studentobj.Email = email;
    studentobj.Gender = Gender;
    studentobj.RollNumber = RollNumber;
    studentobj.firstName = fname;
    studentobj.lastName = lname;
    studentobj.Occupation = occupation;
    
    arr.push(studentobj);
    document.forms[0].reset();
    console.log(arr.length);
    console.log(arr);
}

// function for fetching the person's details using rollnumber
function fetch() {
    let inputRollNo = document.getElementById("search").value;
    for (let i = 0; i<arr.length; i++) {
        if (arr[i].RollNumber == inputRollNo) {
            var fname = arr[i].firstName;
            var lname = arr[i].lastName;
            var email = arr[i].Email;
            var age = arr[i].Age;
            var DOB = arr[i].DOB;
            var gender = arr[i].Gender;
            var roll = arr[i].RollNumber;
            var occupation = arr[i].Occupation;
            break;
        }
        
    }
    document.getElementById("output").innerHTML = "<b> FirstName </b> : " + fname + "<br>" + 
                                                    "<b> LasttName </b> : " + lname + "<br>" +
                                                    "<b> Email </b> : " + email + "<br>" +
                                                    "<b> RollNumber </b> : " + roll + "<br>" +
                                                    "<b> Gender </b> : " + gender + "<br>" +
                                                    "<b> Age </b> : " + age + "<br>" +
                                                    "<b> DOB </b> : " + DOB + "<br>" + 
                                                    "<b> Occupation : </b> : " + occupation ;
}

