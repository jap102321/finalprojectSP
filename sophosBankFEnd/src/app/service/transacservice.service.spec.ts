import { TestBed } from '@angular/core/testing';

import { TransacserviceService } from './transacservice.service';

describe('TransacserviceService', () => {
  let service: TransacserviceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(TransacserviceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
