import { ComponentFixture, TestBed } from '@angular/core/testing';

import { VetHistory } from './vet-history';

describe('VetHistory', () => {
  let component: VetHistory;
  let fixture: ComponentFixture<VetHistory>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [VetHistory]
    })
    .compileComponents();

    fixture = TestBed.createComponent(VetHistory);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
