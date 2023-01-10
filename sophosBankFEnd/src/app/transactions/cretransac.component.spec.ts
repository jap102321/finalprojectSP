import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CretransacComponent } from './cretransac.component';

describe('CretransacComponent', () => {
  let component: CretransacComponent;
  let fixture: ComponentFixture<CretransacComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CretransacComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CretransacComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
