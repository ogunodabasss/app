import { TestBed } from '@angular/core/testing';

import { GoogleAppService } from './google-app.service';

describe('GoogleAppService', () => {
  let service: GoogleAppService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(GoogleAppService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
