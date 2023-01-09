import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CreatetransacComponent } from './createtransac.component';

describe('CreatetransacComponent', () => {
  let component: CreatetransacComponent;
  let fixture: ComponentFixture<CreatetransacComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CreatetransacComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CreatetransacComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
