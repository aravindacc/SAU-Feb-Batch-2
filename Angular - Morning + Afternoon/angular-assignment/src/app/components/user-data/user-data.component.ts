import { Component, OnInit } from '@angular/core';
import { TableService } from '../../services/table.service';
@Component({
  selector: 'app-user-data',
  templateUrl: './user-data.component.html',
  styleUrls: ['./user-data.component.css'],
})
export class UserDataComponent implements OnInit {
  public title = 'User Data';
  public studentList = this.TableService.getSaveData();
  constructor(private TableService: TableService) {}

  ngOnInit(): void {}
  sortBy(arr) {
    this.studentList = this.TableService.updateList(arr[0], arr[1]);
  }

  deleteStudent(data) {
    this.studentList = this.TableService.filterList(data);
  }

  createStudent(arr) {
    this.studentList = this.TableService.storeData(arr[0], arr[1]);
  }
}
