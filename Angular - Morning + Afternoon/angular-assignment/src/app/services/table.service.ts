import { ComparatorService } from './comparator.service';
import { Injectable } from '@angular/core';
@Injectable({
  providedIn: 'root',
})
export class TableService {
  getSaveData() {
    let data = JSON.parse(sessionStorage.getItem('studentData'));
    if (data === null) {
      data = [];
      sessionStorage.setItem('studentData', JSON.stringify(data));
    }
    return data;
  }

  storeData(student, rollNo) {
    let data = JSON.parse(sessionStorage.getItem('studentData'));

    data = [
      ...data,
      {
        rollNo: rollNo,
        f_name: student.f_name,
        l_name: student.l_name,
        city: student.city,
        phone: student.phone,
        dob: student.dob,
        pincode: student.pincode,
      },
    ];
    sessionStorage.setItem('studentData', JSON.stringify(data));
    return data;
  }

  updateList(colName, type) {
    let data = JSON.parse(sessionStorage.getItem('studentData'));
    return this.compare.bulkSort(data, colName, type);
  }

  filterList(student) {
    let data = JSON.parse(sessionStorage.getItem('studentData'));
    data = data.filter((data) => {
      return data.rollNo != student.rollNo;
    });
    sessionStorage.setItem('studentData', JSON.stringify(data));
    return data;
  }
  constructor(private compare: ComparatorService) {}
}
