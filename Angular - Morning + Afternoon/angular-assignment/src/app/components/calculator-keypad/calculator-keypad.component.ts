import { Component, OnInit, EventEmitter, Output } from '@angular/core';

@Component({
  selector: 'app-calculator-keypad',
  templateUrl: './calculator-keypad.component.html',
  styleUrls: ['./calculator-keypad.component.css'],
})
export class CalculatorKeypadComponent implements OnInit {
  public res = '';
  public currStr = '';
  public error = false;
  public stack = {
    num1: null,
    symbol: null,
    num2: null,
  };

  constructor() {}

  ngOnInit(): void {}

  handleButtonClick(data) {
    console.log(data);
    if (data === 'C') {
      this.clear();
    } else if (data === '+' || data === '-' || data === '*' || data === '/') {
      this.checkSymbolValidation(data);
    } else if (data === '=') {
      this.calculate();
    } else {
      this.setNumbers(data);
    }

    this.getOutput();
  }

  getOutput() {
    console.log('Answer is: ' + this.res);
    console.log('Stack is: ' + JSON.stringify(this.stack));
  }

  setNumbers(num) {
    if (this.stack.num1 === null || this.stack.symbol === null) {
      if (
        num === '.' &&
        this.stack.num1 != null &&
        this.stack.num1.includes('.')
      ) {
        return;
      }
      this.stack.num1 = this.stack.num1 === null ? num : this.stack.num1 + num;
    } else if (this.stack.num1 != null && this.stack.symbol != null) {
      if (
        num === '.' &&
        this.stack.num2 != null &&
        this.stack.num2.includes('.')
      ) {
        return;
      }
      this.stack.num2 = this.stack.num2 === null ? num : this.stack.num2 + num;
    } else {
      console.log('Logic Error');
      return;
    }
    this.currStr += num;
  }

  checkSymbolValidation(symbol) {
    if (this.stack.num1 != null && this.stack.symbol === null) {
      this.stack.symbol = symbol;
      this.currStr += symbol;
    } else if (this.isValidStack()) {
      this.calculate();
      this.checkSymbolValidation(symbol);
    } else {
      this.error = true;
    }
  }

  isValidStack() {
    if (
      this.stack.num1 != null &&
      this.stack.symbol != null &&
      this.stack.num2 != null
    ) {
      return true;
    }
    return false;
  }

  createStack(num1, symbol, num2) {
    this.stack = {
      num1: num1,
      symbol: symbol,
      num2: num2,
    };
  }

  calculate() {
    let ans = '';
    if (this.isValidStack()) {
      if (this.stack.symbol === '+') {
        ans = (
          parseFloat(this.stack.num1) + parseFloat(this.stack.num2)
        ).toString();
      } else if (this.stack.symbol === '-') {
        ans = (
          parseFloat(this.stack.num1) - parseFloat(this.stack.num2)
        ).toString();
      } else if (this.stack.symbol === '*') {
        ans = (
          parseFloat(this.stack.num1) * parseFloat(this.stack.num2)
        ).toString();
      } else if (this.stack.symbol === '/') {
        ans = (
          parseFloat(this.stack.num1) / parseFloat(this.stack.num2)
        ).toString();
      }

      this.res = ans.toString();
      this.currStr = this.res;
      this.createStack(ans, null, null);
      // this.getOutput();
      return;
    }
    console.log('Logic Error');
  }

  clear() {
    this.res = '';
    this.currStr = '';
    this.createStack(null, null, null);
  }
}
