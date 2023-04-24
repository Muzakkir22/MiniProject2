import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
  title = 'Client';
  flag:boolean = true

  apply(value:string){
    this.flag = value == "login"?true : false;
  } 

  ngOnInit(): void {
      
  }
  
  // this.router.navigate(['/search']);
}