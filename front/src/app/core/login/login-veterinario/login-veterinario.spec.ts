import { ComponentFixture, TestBed } from '@angular/core/testing';
import { LoginVeterinario } from './login-veterinario';
import { FormsModule } from '@angular/forms';
import { Router } from '@angular/router';

describe('veterinarioLoginComponent', () => {
  let component: LoginVeterinario;
  let fixture: ComponentFixture<LoginVeterinario>;
  let routerSpy: jasmine.SpyObj<Router>;

  beforeEach(() => {
    routerSpy = jasmine.createSpyObj('Router', ['navigate']);

    TestBed.configureTestingModule({
      declarations: [LoginVeterinario],
      imports: [FormsModule],
      providers: [{ provide: Router, useValue: routerSpy }]
    });

    fixture = TestBed.createComponent(LoginVeterinario);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create the component', () => {
    expect(component).toBeTruthy();
  });

  it('should navigate to dashboard on valid login', () => {
    component.email = 'admin@example.com';
    component.password = '123456';
    const event = new Event('submit');
    component.handleLogin(event);
    expect(routerSpy.navigate).toHaveBeenCalledWith(['/admin/dashboard']);
  });
});
