function displaylength() {
    let input_string = document.getElementById("input-string").value;
    document.getElementById("len").innerHTML = input_string.length;
    console.log("Length of string = " + input_string.length);
}


function casechange() {
    let input_string = document.getElementById("input-string").value;
    let result = "UpperCase : " + input_string.toUpperCase() + " <br> "+ "LowerCase : " + input_string.toLowerCase();
    document.getElementById("upper-lower").innerHTML = result;
    console.log(result);
}


function separatevowels() {
    let input_string = document.getElementById("input-string").value;
    let vowels = "";
    let consonents = "";
    for (let i = 0; i<input_string.length; i++) {
        if (input_string[i] != ' ' && (input_string[i] >= 'a' && input_string[i] <= 'z') || (input_string[i] >= 'A' && input_string[i] <= 'Z'))
        {
            if (input_string[i] == 'a' || input_string[i] == 'e' || input_string[i] == 'i' || input_string[i] == 'o'||
            input_string[i] == 'u') {
                vowels += input_string[i];
                vowels += " , ";
            }
            else {
                consonents += input_string[i];
                consonents += " , ";
            }
        }
    }
    vowels = vowels.substr(0, vowels.length - 2);
    consonents = consonents.substr(0, consonents.length - 2);
    let result = "Vowels = " + vowels +" <br> " + "Consonents = " + consonents;
    document.getElementById("vowels").innerHTML = result;
    console.log(result);
}

function checkfornumber() {
    let input_string = document.getElementById("input-string").value;
    let hasNumber = false;
    for (let i = 0; i < input_string.length; i++) {
        if (input_string[i] != ' ' && input_string[i] - "0" >= 0) {
            hasNumber = true;
            document.getElementById("check").innerHTML = "Input string has a number";
            console.error("Input string has a number");
            break;
        }
        else if (i == input_string.length-1){
            console.log("Input string does not have a number");
            document.getElementById("check").innerHTML = "Input string doesn't have a number";
            break;
        }
    }
     
    
}


