import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CalculatorKeypadComponent } from './calculator-keypad.component';

describe('CalculatorKeypadComponent', () => {
  let component: CalculatorKeypadComponent;
  let fixture: ComponentFixture<CalculatorKeypadComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CalculatorKeypadComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(CalculatorKeypadComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
