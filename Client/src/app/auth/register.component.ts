import { HttpHeaders } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { register } from './register.model';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  successMessage:string =""

  regForm!:FormGroup

  constructor(private fb: FormBuilder, private router: Router) { }

  ngOnInit(): void {
    this.regForm = this.fb.group({
      username: ['',[Validators.required]],
      // mobileNumber: ['',[Validators.required, Validators.min(80000000),Validators.max(99999999)]],
      email:['',[Validators.required, Validators.pattern("[a-zA-Z0-9]*@gmail.com")]],
      password: ['',[Validators.required,Validators.pattern("[a-zA-z@_]{6,}")]]
    })
  }

  register(){
    this.successMessage = "Successfully Registered...";
    // console.log(this.regForm)

    const headers = new HttpHeaders()
      .set('content-type', 'application/json')
      .set('Access-Control-Allow-Origin', '*');

    var username = this.regForm.get("username")?.value;
    var email = this.regForm.get("email")?.value;
    var password = this.regForm.get("password")?.value;

    // var registerModel: registerModel = {
    //   username: username,
    //   email: email,
    //   password: password,
    // }

  //   var url = '/register';
  //   var registerResult : register;
  //   var


    this.router.navigate(['/search']);
  }

}