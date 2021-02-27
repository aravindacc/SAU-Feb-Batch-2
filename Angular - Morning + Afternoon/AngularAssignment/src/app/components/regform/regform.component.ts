import { FormGroup , FormControl, Validators ,FormBuilder} from '@angular/forms';
import { Component, OnInit} from '@angular/core';
import {MatTableDataSource} from '@angular/material/table';
import {MatSort,MatSortable} from '@angular/material/sort';
import DeleteIcon from '@material-ui/icons/Delete';
import {MatIconModule} from '@angular/material/icon';
import { IconButton } from '@material-ui/core';
import {Student} from './employeetype';
import { ViewChild } from '@angular/core';
@Component({
  selector: 'app-regform',
  templateUrl: './regform.component.html',
  styleUrls: ['./regform.component.css']
})
export class RegformComponent implements OnInit
{
  @ViewChild(MatSort) sort : MatSort;
    title = 'AngularAssign';
    dataSource;
    displayedColumns = ['firstname','lastname','cno','dob','city','pincode','actions'];
    public employees : Student []=[];
    employeeForm : FormGroup;
    constructor(){ }
    ngOnInit()
    {
      
      this.employeeForm = new FormGroup({
        firstname: new FormControl('', [Validators.required]),
        lastname : new FormControl('', [Validators.required]),
        cno : new FormControl('', [Validators.required, Validators.maxLength(10)]),
        dob : new FormControl('', [Validators.required]),
        city : new FormControl('', [Validators.required]),
        pincode : new FormControl('', [Validators.minLength(6)])
      });
      
    }
 
    onSubmit(): void
    {
      let temp=this.employeeForm.value;
      console.log(temp);
      const record : Student = 
      {
        firstname : temp.firstname,
        lastname : temp.lastname,
        cno : temp.cno, 
        dob : temp.dob,
        city : temp.city,
        pincode : temp.pincode,
      };
     //to store the data in session storage
      this.employees.push(record);
      sessionStorage.setItem('Employees', JSON.stringify(this.employees));
      console.log(this.employees);
      this.dataSource=new MatTableDataSource(this.employees);
      this.dataSource.sort=this.sort;
    }

    get firstname() 
    {
      return this.employeeForm.get('firstname');
    }
    get lastname() 
    {
      return this.employeeForm.get('lastname');
    }
    get dob() 
    {
      return this.employeeForm.get('dob');
    }
    get cno() 
    {
      return this.employeeForm.get('cno');
    }
    get city() 
    {
      return this.employeeForm.get('city');
    }
    get pincode() {
      return this.employeeForm.get('pincode');
    }
    //Deleting the records based on contact number (cno) as they are unique for each user or employee
    deleteRecord(cno):void
    {
      //alert(this.employees.length);
      for(let i = 0; i < this.employees.length; ++i)
      {
        //alert(this.employees[i].firstname);
        if (this.employees[i].cno === cno)
        {
            this.employees.splice(i,1);
            this.dataSource=new MatTableDataSource(this.employees);
        }
      }
        //console.log(cno);
    }
    
}
