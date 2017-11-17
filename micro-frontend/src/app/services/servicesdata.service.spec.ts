import { TestBed, inject } from '@angular/core/testing';

import { ServicesdataService } from './servicesdata.service';

describe('ServicesdataService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [ServicesdataService]
    });
  });

  it('should be created', inject([ServicesdataService], (service: ServicesdataService) => {
    expect(service).toBeTruthy();
  }));
});
