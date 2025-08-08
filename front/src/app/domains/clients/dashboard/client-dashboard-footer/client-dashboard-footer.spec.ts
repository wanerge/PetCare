import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ClientDashboardFooter } from './client-dashboard-footer';

describe('ClientDashboardFooter', () => {
  let component: ClientDashboardFooter;
  let fixture: ComponentFixture<ClientDashboardFooter>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ClientDashboardFooter]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ClientDashboardFooter);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
