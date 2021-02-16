function displayOutput(data, isClear) {
  if (isClear) {
    document.getElementById("myTerminal").innerHTML = `<p style="padding-top: 1px;"></p>`;
  }
  for (let i = 0; i < data.length; i++) {
    document.getElementById("myTerminal").innerHTML += `<p class="terminalOutput">&nbsp;&nbsp;>&nbsp;&nbsp;` + data[i] + `</p>`;
  }
  document.getElementById("myTerminal").innerHTML += `<p class="terminalOutput">----------------------------------------------</p>`;
}

function isValid(string) {
  if (/[^a-zA-Z]/.test(string)) {
    return false;
  }
  return true;
}

function totalLength(isClear) {
  let inputString = document.getElementById("inp1").value;

  if (!isValid(inputString)) {
    alert("Error: Number Is Present In The String!!");
    return;
  }

  console.log("Length is : " + inputString.length);
  displayOutput(["Length is : " + inputString.length], isClear);
}


function upperAndLowerCase(isClear) {
  let inputString = document.getElementById("inp1").value;

  if (!isValid(inputString)) {
    alert("Error: Number Is Present In The String!!");
    return;
  }

  console.log("Upper Case String : " + inputString.toUpperCase());
  console.log("Lower Case String : " + inputString.toLowerCase());
  displayOutput(["Upper Case String : " + inputString.toUpperCase(), "Lower Case String : " + inputString.toLowerCase()], isClear);
}


function seperateVowels(isClear) {
  let inputString = document.getElementById("inp1").value;

  if (!isValid(inputString)) {
    alert("Error: Number Is Present In The String!!");
    return;
  }

  let vowels = ['a', 'e', 'i', 'o', 'u'];
  let vowelString = "";
  let consonantString = "";
  for (let i = 0; i < inputString.length; i++) {
    if (vowels.includes(inputString.charAt(i).toLowerCase()) || vowels.includes(inputString.charAt(i).toUpperCase())) {
      vowelString += inputString.charAt(i);
    }
    else {
      consonantString += inputString.charAt(i);
    }
  }
  console.log("Vowels String : " + vowelString);
  console.log("Consonants String : " + consonantString);
  displayOutput(["Vowels String : " + vowelString, "Consonants String : " + consonantString], isClear);
}


function automate() {
  console.clear();

  if (!isValid(document.getElementById("inp1").value)) {
    alert("Error: Number Is Present In The String!!");
    return;
  }

  totalLength(true);
  upperAndLowerCase(false);
  seperateVowels(false);
}