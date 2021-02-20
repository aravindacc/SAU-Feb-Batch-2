import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'customdob'
})
export class CustomdobPipe implements PipeTransform {

  
  public Months = ["January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"];

  transform(currentdob: string, date_format: string) {
    
    if (date_format === "months day, year") {

      let datefragments = currentdob.split("-");
      return ((this.Months[parseInt(datefragments[1])-1]) +
              " " + datefragments[2] +
              " , " + datefragments[0]);
    } 
    return currentdob;
  }
}


