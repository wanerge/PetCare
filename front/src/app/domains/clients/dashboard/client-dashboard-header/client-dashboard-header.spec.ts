import { ComponentFixture, TestBed } from '@angular/core/testing';
import { ClientDashboardHeader } from './client-dashboard-header';

describe('ClientDashboardHeader', () => {
  let component: ClientDashboardHeader;
  let fixture: ComponentFixture<ClientDashboardHeader>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ClientDashboardHeader]
    })
      .compileComponents();

    fixture = TestBed.createComponent(ClientDashboardHeader);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
