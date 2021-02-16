import { Component, OnInit, Input, AfterViewInit } from '@angular/core';

@Component({
  selector: 'app-calculator-screen',
  templateUrl: './calculator-screen.component.html',
  styleUrls: ['./calculator-screen.component.css'],
})
export class CalculatorScreenComponent implements OnInit {
  @Input() public res;
  constructor() {}

  ngOnInit(): void {
    console.log('My res' + JSON.stringify(this.res));
  }

  ngAfterViewInit() {
    console.log('My res ngAfterView: ' + JSON.stringify(this.res));
  }
}
