import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, FormBuilder, Validators } from '@angular/forms';
import { Student } from './studentschema';

@Component({
  selector: 'app-registration',
  templateUrl: './registration.component.html',
  styleUrls: ['./registration.component.css']
})
export class RegistrationComponent implements OnInit {
  registrationForm: FormGroup;
  constructor(private fb: FormBuilder) { }


  ngOnInit() {
    this.registrationForm = this.fb.group({
      firstName: ['', [Validators.required]],
        lastName: ['', [Validators.required]],
        contact: ['', [Validators.required, Validators.maxLength(10)]],
        dob: ['', [Validators.required]],
        city: ['', [Validators.required]],
        zip: ['', [Validators.minLength(6)]]
      }
    );
  }


  get firstName() {
    return this.registrationForm.get('firstName');
  }

  get dob() {
    return this.registrationForm.get('dob');
  }

  get lastName() {
    return this.registrationForm.get('lastName');
  }
  get contact() {
    return this.registrationForm.get('contact');
  }
  get city() {
    return this.registrationForm.get('city');
  }
  get zip() {
    return this.registrationForm.get('zip');
  }

  

  public users : Student[] = [];


  onsubmit() {
    let result = this.registrationForm.value;
    const record : Student = {
      firstname : result.firstName,
      lastname : result.lastName,
      contact : result.contact, 
      dob : result.dob,
      city : result.city,
      zip : result.zip,
    };

    this.users.push(record);
  
    sessionStorage.setItem('Users', JSON.stringify(this.users));
    console.log(typeof(this.users));
  }

  // For deleting a record
  delete(firstname:string) {
      this.users = this.users.filter(item => item.firstname != firstname);
      sessionStorage.setItem('Users', JSON.stringify(this.users));
  }
  
  // boolean function used in ngIf directive
  displaytable() {
    if (this.users.length > 0) {
      return true;
    }
    return false;
  }
  
  public flag = 1;
  public arrow = "";
  

 /* public sorttable(column:string) {
    
    if (this.flag == 1)
    {  this.users = this.users.sort((x:Student, y: Student) => {
        if (x[column] < y[column]) {
          return -1;
        }
        if (x[column] > y[column]) {
          return 1;
        }
        return 0;
      });
      this.flag = 0;
      this.arrow = "↑";
      
    }
    else {
      this.users = this.users.sort((x:Student, y: Student) => {
        if (x[column] > y[column]) {
          return -1;
        }
        if (x[column] < y[column]) {
          return 1;
        }
        return 0;
      });
      
      this.flag = 1;
      this.arrow = "↓";
      
    }
    
    sessionStorage.setItem('Users', JSON.stringify(this.users));
    console.log(this.users);
  }*/

}

