import { ComponentFixture, TestBed } from '@angular/core/testing';
import { LoginCliente } from './login-cliente';
import { FormsModule } from '@angular/forms';
import { Router } from '@angular/router';

describe('ClientLogin Component', () => {
  let component: LoginCliente;
  let fixture: ComponentFixture<LoginCliente>;
  let mockRouter: jasmine.SpyObj<Router>;

  beforeEach(async () => {
    mockRouter = jasmine.createSpyObj('Router', ['navigate']);

    await TestBed.configureTestingModule({
      imports: [FormsModule],
      declarations: [LoginCliente],
      providers: [
        { provide: Router, useValue: mockRouter }
      ],
    }).compileComponents();

    fixture = TestBed.createComponent(LoginCliente);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create the component', () => {
    expect(component).toBeTruthy();
  });

  it('should navigate on successful login', () => {
    component.loginEmail = 'test@example.com';
    component.loginPassword = 'password';
    component.handleLogin();

    expect(mockRouter.navigate).toHaveBeenCalledWith(['/client/dashboard']);
  });

  it('should alert if fields are empty', () => {
    spyOn(window, 'alert');
    component.loginEmail = '';
    component.loginPassword = '';
    component.handleLogin();

    expect(window.alert).toHaveBeenCalledWith('Completa los campos de inicio de sesión.');
  });
});
