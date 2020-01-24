import { TestBed, async, inject } from '@angular/core/testing';

import { SecureGuarGuard } from './secure-guar.guard';

describe('SecureGuarGuard', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [SecureGuarGuard]
    });
  });

  it('should ...', inject([SecureGuarGuard], (guard: SecureGuarGuard) => {
    expect(guard).toBeTruthy();
  }));
});
