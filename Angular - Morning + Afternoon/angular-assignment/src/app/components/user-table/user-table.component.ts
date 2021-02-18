import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';

@Component({
  selector: 'app-user-table',
  templateUrl: './user-table.component.html',
  styleUrls: ['./user-table.component.css'],
})
export class UserTableComponent implements OnInit {
  public sort = {
    one: 'asc',
    two: 'asc',
    three: 'asc',
    four: 'asc',
    five: 'asc',
    six: 'asc',
    seven: 'asc',
  };
  public title = 'Student Data';

  @Input() public studentList;
  @Output() public sortTable = new EventEmitter();
  @Output() public deleteUser = new EventEmitter();
  constructor() {}

  ngOnInit(): void {}

  sortBy(colName) {
    let type = '';
    if (colName === 'f_name') {
      type = 'two';
    } else if (colName === 'l_name') {
      type = 'three';
    } else if (colName === 'city') {
      type = 'six';
    } else if (colName === 'pincode') {
      type = 'seven';
    } else if (colName === 'dob') {
      type = 'five';
    } else if (colName === 'phone') {
      type = 'four';
    } else if (colName === 'rollNo') {
      type = 'one';
    }
    this.sort[type] = this.sort[type] === 'asc' ? 'dsc' : 'asc';
    let sortType = this.sort[type];
    this.sortTable.emit([colName, sortType]);
  }

  deleteStudent(data) {
    this.deleteUser.emit(data);
  }
}
