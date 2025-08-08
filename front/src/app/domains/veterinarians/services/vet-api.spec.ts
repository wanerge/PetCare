import { TestBed } from '@angular/core/testing';

import { VetApi } from './vet-api';

describe('VetApi', () => {
  let service: VetApi;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(VetApi);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
