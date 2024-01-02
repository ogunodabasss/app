import { ComponentFixture, TestBed } from '@angular/core/testing';

import { GoogleAppComponent } from './google-app.component';

describe('GoogleAppComponent', () => {
  let component: GoogleAppComponent;
  let fixture: ComponentFixture<GoogleAppComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [GoogleAppComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(GoogleAppComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
