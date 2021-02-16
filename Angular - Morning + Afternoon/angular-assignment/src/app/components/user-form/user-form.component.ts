import { TableService } from './../../services/table.service';
import { Component, OnInit, Output, EventEmitter } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
@Component({
  selector: 'app-user-form',
  templateUrl: './user-form.component.html',
  styleUrls: ['./user-form.component.css'],
})
export class UserFormComponent implements OnInit {
  public title = 'Add Student Details Below';
  public rollNo = '1';
  public studentForm: FormGroup;
  public submitted = false;
  @Output() public createEntry = new EventEmitter();

  constructor(
    private formBuilder: FormBuilder,
    private tableService: TableService
  ) {
    let stored = sessionStorage.getItem('lastRollNo');
    if (stored != 'NaN' && stored != null) {
      this.rollNo = (parseInt(stored) + 1).toString();
    } else {
      sessionStorage.setItem('lastRollNo', '1');
    }
    console.log(sessionStorage.getItem('lastRollNo'));
  }

  ngOnInit(): void {
    this.studentForm = this.formBuilder.group({
      f_name: ['', [Validators.required]],
      l_name: ['', [Validators.required]],
      phone: ['', [Validators.required, Validators.maxLength(10)]],
      city: ['', [Validators.required]],
      pincode: ['', [Validators.required, Validators.maxLength(6)]],
      dob: ['', [Validators.required]],
      check: [false, [Validators.requiredTrue]],
    });
  }

  createStudent() {
    if (this.studentForm.valid) {
      this.submitted = false;
      let student = this.studentForm.value;
      console.log(this.studentForm.value);
      let rollNumber = this.rollNo;
      this.createEntry.emit([student, rollNumber]);
      sessionStorage.setItem('lastRollNo', this.rollNo);
      this.rollNo = (parseInt(this.rollNo) + 1).toString();
    } else {
      this.submitted = true;
    }
  }
}
