var firstname=document.getElementById("firstname");
var lastname=document.getElementById("lastname");
var dob = document.getElementById("dob");
var gender = document.getElementById("gender") ;
var age= document.getElementById("age");
var rollno=document.getElementById("rollno");

function Student(firstname,lastname,dob, gender,age,rollno) 
{
    this.firstname=firstname;
    this.lastname=lastname;
    this.dob = dob;
    this.gender=gender;
    this.age=age;
    this.rollno=rollno;
}
dob.onblur = function () {
    var dobPattern = /^\d{2}(\/|\:|\-)\d{2}\1\d{4}$/;
    var dobvalue = dob.value;
    if (!dobPattern.test(dobvalue))
    {
        alert("Invalid dob");
    }
}
gender.onblur=function()
{
    var genderpattern=/^male$|^female$/g;
    var gendervalue=gender.value;
    if(!genderpattern.test(gendervalue))
       {
           alert("Invalid Gender");
       }
}

age.onblur=function()
{
    var agepattern=/^\S[0-9]{0,3}$/;
    var agevalue=age.value;
       if(!agepattern.test(agevalue))
       {
           alert("Invalid age");
       }
}

rollno.onblur = function () 
{
    var i; var c = 0;
    for (i = 0; i < localStorage.length; i++) {
        if (localStorage.key(i) == rollno.value) {
            alert("user already exist");
            rollno.focus();
            rollno.select();
            c = 1;
        }
        else
            break;
    }
    if (c == 0)
        alert("stored in local memory");
}

function submit() 
{
     if (firstname.value!="" && lastname.value!="" && age.value != "" && gender.value != "" && dob.value != "" && rollno.value != "") {
        alert("You are successfully registered");
        let obj = new Student(firstname.value,lastname.value, dob.value, gender.value, age.value,rollno.value);
        localStorage.setItem(rollno.value, JSON.stringify(obj));
    }

    else
        alert("fill all details");

}
function Fetch_Details()
{
    var r=document.getElementById("sroll");
    document.getElementById("sdetails").innerHTML=localStorage.getItem(r.value);
} 