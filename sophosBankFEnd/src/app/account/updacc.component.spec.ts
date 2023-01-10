import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UpdaccComponent } from './updacc.component';

describe('UpdaccComponent', () => {
  let component: UpdaccComponent;
  let fixture: ComponentFixture<UpdaccComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ UpdaccComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(UpdaccComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
