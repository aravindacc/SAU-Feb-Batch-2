import { ReactiveFormsModule, FormsModule } from '@angular/forms';
import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { CalculatorScreenComponent } from './components/calculator-screen/calculator-screen.component';
import { CalculatorKeypadComponent } from './components/calculator-keypad/calculator-keypad.component';
import { UserTableComponent } from './components/user-table/user-table.component';
import { UserFormComponent } from './components/user-form/user-form.component';
import { UserDataComponent } from './components/user-data/user-data.component';
import { CustomDatePipe } from './pipes/customDate.pipe';

@NgModule({
  declarations: [
    AppComponent,
    CalculatorScreenComponent,
    CalculatorKeypadComponent,
    UserTableComponent,
    UserFormComponent,
    UserDataComponent,
    CustomDatePipe,
  ],
  imports: [BrowserModule, AppRoutingModule, ReactiveFormsModule, FormsModule],
  providers: [],
  bootstrap: [AppComponent],
})
export class AppModule {}
