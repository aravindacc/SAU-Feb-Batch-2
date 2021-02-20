import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'customeDOB'
})
export class CustomeDOBPipe implements PipeTransform {

  public months = {
    '01': "January",
    '02': "February",
    '03': "March",
    '04': "April",
    '05': "May",
    '06': "June",
    '07': "July",
    '08': "August",
    '09': "September",
    '10': "October",
    '11': "November",
    '12': "December"
  }

  transform(value: String, ...args: unknown[]): String {
    var [year, month, date] = value.split('-');
    return this.months[month] + " " + date + ", " + year;
  }

}
