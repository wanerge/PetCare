import { ComponentFixture, TestBed } from '@angular/core/testing';

import { VetNavbar } from './vet-navbar';

describe('VetNavbar', () => {
  let component: VetNavbar;
  let fixture: ComponentFixture<VetNavbar>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [VetNavbar]
    })
    .compileComponents();

    fixture = TestBed.createComponent(VetNavbar);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
