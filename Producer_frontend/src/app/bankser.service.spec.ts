import { TestBed } from '@angular/core/testing';

import { BankserService } from './bankser.service';

describe('BankserService', () => {
  let service: BankserService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(BankserService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
