import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ViewDriveComponent } from './view-drive.component';

describe('ViewDriveComponent', () => {
  let component: ViewDriveComponent;
  let fixture: ComponentFixture<ViewDriveComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ViewDriveComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ViewDriveComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
