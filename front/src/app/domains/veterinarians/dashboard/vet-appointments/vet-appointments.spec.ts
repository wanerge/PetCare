import { ComponentFixture, TestBed } from '@angular/core/testing';

import { VetAppointments } from './vet-appointments';

describe('VetAppointments', () => {
  let component: VetAppointments;
  let fixture: ComponentFixture<VetAppointments>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [VetAppointments]
    })
    .compileComponents();

    fixture = TestBed.createComponent(VetAppointments);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
