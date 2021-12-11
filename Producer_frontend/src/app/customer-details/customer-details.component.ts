import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Bankmodule } from '../Bankmodule';
import { BankserService } from '../bankser.service';

@Component({
  selector: 'app-customer-details',
  templateUrl: './customer-details.component.html',
  styleUrls: ['./customer-details.component.css']
})
export class CustomerDetailsComponent implements OnInit {

  constructor(private service:BankserService,private route:Router,private router:ActivatedRoute) { }
  id:any;
  customer:any;
  ngOnInit() {

    this.customer=new Bankmodule();
    this.id=this.router.snapshot.params['id'];
    this.service.getcustomerbyid(this.id).subscribe(data => {
      console.log(data)
      this.customer = data;
    }, error => console.log(error));
  }

  list(){
    this.route.navigate(['/bankcustomer']);
  }
}
