import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
})
export class AppComponent {
  title = 'angular-assignment';
  current = this.getCurrentName();

  getCurrentName() {
    let currUrl = window.location.href.split('/');
    if (currUrl[currUrl.length - 1].includes('calculator')) {
      return 'calculator';
    } else {
      return 'home';
    }
  }
}
