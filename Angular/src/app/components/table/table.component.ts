import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-table',
  templateUrl: './table.component.html',
  styleUrls: ['./table.component.css']
})
export class TableComponent implements OnInit {

  public employees = []

  constructor() {
  }

  ngOnInit(): void {
  }

  getData() {
    let employees = JSON.parse(sessionStorage.getItem("employees"));
    return employees;
  }

  displayData() {
    console.log("Employees Length" + this.employees.length);
    if(this.employees.length > 0) {
      return true;
    }
    return false;
  }

  delete(index) {
    let employees = JSON.parse(sessionStorage.getItem("employees"));
    employees.splice(index, 1);
    sessionStorage.setItem("employees", JSON.stringify(employees));
  }

  sort(category) {
    let employees = JSON.parse(sessionStorage.getItem("employees"));
    if (category == "first_name") {
      employees.sort((a, b) => (a.first_name > b.first_name) ? 1 : -1)
    } else if (category == "last_name") {
      employees.sort((a, b) => (a.last_name > b.last_name) ? 1 : -1)
    } else if (category == "contact_no") {
      employees.sort((a, b) => (a.contact_no > b.contact_no) ? 1 : -1)
    } else if (category == "dob") {
      employees.sort((a, b) => (a.dob > b.dob) ? 1 : -1)
    } else if (category == "city") {
      employees.sort((a, b) => (a.city > b.city) ? 1 : -1)
    } else if (category == "pincode") {
      employees.sort((a, b) => (a.pincode > b.pincode) ? 1 : -1)
    }
    sessionStorage.setItem("employees", JSON.stringify(employees));
  }

}
