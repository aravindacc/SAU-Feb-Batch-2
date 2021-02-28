function hasNumber(string) {
    const integers = ["1", "2", "3", "4", "5", "6", "7", "8", "9", "0"];
    for (const char of string) {
        if (integers.indexOf(char) != -1) {
            return true;
        }
    }
    return false;
  }

function length() {
    let string = document.getElementById("input").value;
    if (hasNumber(string)) {
        alert("Invalid String");
    } else {
        document.getElementById("result").style.marginTop = 10;
        document.getElementById("result").innerHTML = "Length of String: " + string.length;
    } 
}

function upperCase() {
    let string = document.getElementById("input").value;
    if (hasNumber(string)) {
        alert("Invalid String");
    } else {
        document.getElementById("result").innerHTML = "UpperCase: " + string.toUpperCase();
    }
}

function lowerCase() {
    let string = document.getElementById("input").value;
    if (hasNumber(string)) {
        alert("Invalid String");
    } else {
        document.getElementById("result").innerHTML = "LowerCase: " + string.toLowerCase();
    }
}

function seperateVowelsAndConsolnants() {
    let string = document.getElementById("input").value;
    if (hasNumber(string)) {
        alert("Invalid String");
    } else {
        let vowels = ""
        let consonants = ""
        for(let char of string) {
            char = char.toLowerCase();
            if (char == "a" || char == "e" || char == "i" || char == "o" || char == "u") {
                vowels += char;
            } else {
                consonants += char;
            }
        }
        document.getElementById("result").innerHTML = "Vowels String: " + vowels + "<br>" + "Consonants String: " + consonants; 
    }
}