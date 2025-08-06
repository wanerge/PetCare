import { ComponentFixture, TestBed } from '@angular/core/testing';
import { ClientDashboard } from './client-dashboard';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';

describe('ClientDashboard', () => {
  let component: ClientDashboard;
  let fixture: ComponentFixture<ClientDashboard>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ClientDashboard, CommonModule, FormsModule]
    }).compileComponents();

    fixture = TestBed.createComponent(ClientDashboard);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create the component', () => {
    expect(component).toBeTruthy();
  });
});
