function strlen() {
  var str = document.getElementById("mytext").value;
  var n = str.length;
  document.getElementById("len").innerHTML =
    "The length of the input string is : " + n;
}
function toupplow() {
  var upper = (document.getElementById(
    "tb2a"
  ).innerHTML = document.getElementById("mytext").value.toUpperCase());
  var lower = (document.getElementById(
    "tb2b"
  ).innerHTML = document.getElementById("mytext").value.toLowerCase());

  document.getElementById("tb2a").innerHTML =
    "The input string in UpperCase : " + upper;

  document.getElementById("tb2b").innerHTML =
    "The input string in LowerCase : " + lower;
}
function countofvnc() {
  var str = document.getElementById("mytext").value;
  const vowels = ["a", "e", "i", "o", "u"];
  const consonants = [
    "b",
    "c",
    "d",
    "f",
    "g",
    "h",
    "j",
    "k",
    "l",
    "m",
    "n",
    "p",
    "q",
    "r",
    "s",
    "t",
    "v",
    "w",
    "x",
    "y",
    "z",
  ];
  let c = 0,
    c1 = 0;
  for (let letter of str.toLowerCase()) {
    if (vowels.includes(letter)) {
      c++;
    } else if (consonants.includes(letter)) {
      c1++;
    }
  }
  document.getElementById("tb3a").innerHTML =
    "No.of Vowels in the input string : " + c;
  document.getElementById("tb3b").innerHTML =
    "No.of Consonants in the input string : " + c1;
}
function checknum() {
  var hasNumber = /\d/;
  var str = document.getElementById("mytext").value;
  if (hasNumber.test(str)) {
    document.getElementById("tb4").innerHTML =
      "The string contains a number in it";
  } else {
    document.getElementById("tb4").innerHTML =
      "The string does not contain a number in it";
  }
}
