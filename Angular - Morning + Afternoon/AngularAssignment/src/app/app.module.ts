import { NgModule,Pipe,PipeTransform } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppComponent } from './app.component';
import { RegformComponent } from './components/regform/regform.component';
import{ ReactiveFormsModule } from '@angular/forms';
import{HttpClientModule} from '@angular/common/http';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations'
import { MatSortModule} from '@angular/material/sort';
import {MatTableModule} from '@angular/material/table';
import {MatButtonModule} from '@angular/material/button';
import {MatIconModule} from '@angular/material/icon';
import { DatePipe } from '@angular/common';
import { pipe } from 'rxjs';
const MaterialComponents = [MatButtonModule];
@Pipe({
  name: 'customDate'
})
export class CustomDatePipe extends 
             DatePipe implements PipeTransform {
  transform(value: any, args?: any): any {
    return super.transform(value, "EEEE d MMMM y h:mm a");
  }
}
@NgModule({
  declarations: [
    AppComponent,
    RegformComponent,
    CustomDatePipe,
  ],
  imports: [
    BrowserModule,
    ReactiveFormsModule,
    HttpClientModule,
    BrowserAnimationsModule,
    MatSortModule,
    MatTableModule,
    MatButtonModule,
    MaterialComponents,
    MatIconModule,
  ],
  exports:[MaterialComponents],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
export class MaterialModule { }
