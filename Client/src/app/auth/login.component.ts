import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { login } from './login.model';

export interface loginModel {
  password: string,
  email: string
}

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  successMessage:string ="";
  loginForm!: FormGroup; 
  constructor(private fb: FormBuilder, private router: Router, private http: HttpClient) { }

  ngOnInit(): void {
    this.loginForm = this.fb.group({
      email:['',[Validators.required, Validators.pattern("[A-Za-z0-9]*@gmail.com")]],
      password:['',[Validators.required,Validators.pattern("[A-Za-z0-9@!_]{6,}")]]
    })
  }

  login(){
    this.successMessage="Successfully Login In...";
   
    
    const headers = new HttpHeaders()
        .set('content-type', 'application/json')
        .set('Access-Control-Allow-Origin', '*');

    var email = this.loginForm.get("email")?.value;
    var password = this.loginForm.get("password")?.value;

    var loginModel: loginModel = {
      email: email,
      password: password
    }

    var url = '/login';
    var loginResult : login;
    var result = this.http.post<login>(url, loginModel, {headers: headers});
    result.subscribe(data => {
    loginResult = data;  
    if(loginResult.result === 'success'){
      alert('Login is successful')
          this.router.navigate(['/search']);

    } else {
      alert('Login is unsuccessful. Please try again')

    }
      
    })

    console.log(this.loginForm)
  }

}