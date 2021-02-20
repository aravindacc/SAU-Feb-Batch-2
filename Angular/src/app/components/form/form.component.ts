import { JsonPipe } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-form',
  templateUrl: './form.component.html',
  styleUrls: ['./form.component.css']
})
export class FormComponent implements OnInit {

  constructor() { }

  ngOnInit(): void {
  }

  employeeForm = new FormGroup({
    first_name: new FormControl('', Validators.required),
    last_name: new FormControl('', Validators.required),
    contact_no: new FormControl('', [Validators.required, Validators.maxLength(10)]),
    dob: new FormControl('', Validators.required),
    city: new FormControl('', Validators.required),
    pincode: new FormControl('', [Validators.required, Validators.maxLength(6)])
  }); 

  onSubmit() {
    const values = this.employeeForm.value;
    if(!sessionStorage.getItem('employees')) {
      sessionStorage.setItem('employees', JSON.stringify([values]));
    } else {
      let employees = JSON.parse(sessionStorage.getItem("employees"));
      employees = [...employees, values];
      sessionStorage.setItem("employees", JSON.stringify(employees));
    }
    this.employeeForm.reset();
  }

  // onSubmit() {
  //   const values = this.employeeForm.value;
  //   if (!sessionStorage.getItem('lastEmployeeKey')) {

  //     // currently no employee is in session storage
  //     // So initilize last Employee Key
  //     sessionStorage.setItem('lastEmployeeKey', '1');

  //     // Add this employee with this key in session storage
  //     sessionStorage.setItem("1", JSON.stringify(values));
  //   } else {

  //     // get last Employee Key and increase it by 1
  //     let lastEmployeeKey = (parseInt(sessionStorage.getItem('lastEmployeeKey'))+1).toString();
  //     console.log(lastEmployeeKey);

  //     // add employee by this key
  //     sessionStorage.setItem(lastEmployeeKey, JSON.stringify(values));

  //     // Update the last Employee Key
  //     sessionStorage.setItem('lastEmployeeKey', lastEmployeeKey);
  //   }
  //   this.employeeForm.reset();
  // }

}
