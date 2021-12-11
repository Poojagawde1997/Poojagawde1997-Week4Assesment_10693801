import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Bankmodule } from '../Bankmodule';
import { BankserService } from '../bankser.service';
import {FormControl, FormGroup, Validators} from "@angular/forms";

@Component({
  selector: 'app-createcustomer',
  templateUrl: './createcustomer.component.html',
  styleUrls: ['./createcustomer.component.css']
})
export class CreatecustomerComponent implements OnInit {

  customer:Bankmodule= new Bankmodule();
  submitted = false;
  AddCustomer!:FormGroup;
  
  
  

  constructor(private bankservice:BankserService,private route:Router) { }
  
  
  ngOnInit(){
   
    this.submitted = false;
    this.AddCustomer= new FormGroup({
      name:new FormControl(['',Validators.required]),
      age:new FormControl(['',Validators.required]),
      address:new FormControl(['',Validators.required]),
      typeofacc:new FormControl(['',Validators.required])
    })
  
    this.customer = new Bankmodule();
  }

  save() {
    this.bankservice.createcustomer(this.AddCustomer.value).subscribe(data => {
      console.log(data)
      this.customer = new Bankmodule();
      this.gotoList();
    }, 
    error => console.log(error));
    
  }

  

  onSubmit() {
    this.submitted = true;
    this.save();    
  }

  gotoList() {
    this.route.navigate(['/bankcustomer']);
  }

}
