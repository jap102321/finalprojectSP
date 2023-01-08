import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CraccComponent } from './cracc.component';

describe('CraccComponent', () => {
  let component: CraccComponent;
  let fixture: ComponentFixture<CraccComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CraccComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CraccComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
