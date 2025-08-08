import { ComponentFixture, TestBed } from '@angular/core/testing';

import { VeterinarianMain } from './veterinarian-main';

describe('VeterinarianMain', () => {
  let component: VeterinarianMain;
  let fixture: ComponentFixture<VeterinarianMain>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [VeterinarianMain]
    })
    .compileComponents();

    fixture = TestBed.createComponent(VeterinarianMain);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
