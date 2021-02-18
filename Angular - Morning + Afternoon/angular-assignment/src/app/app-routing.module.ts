import { CalculatorKeypadComponent } from './components/calculator-keypad/calculator-keypad.component';
import { UserDataComponent } from './components/user-data/user-data.component';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

const routes: Routes = [
  { path: '', redirectTo: '/home', pathMatch: 'full' },
  { path: 'calculator', component: CalculatorKeypadComponent },
  { path: 'home', component: UserDataComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
