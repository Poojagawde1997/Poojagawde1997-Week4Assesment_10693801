import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ListcustomerComponent } from './listcustomer/listcustomer.component';
import { CreatecustomerComponent } from './createcustomer/createcustomer.component';
import { UpdatecustomerComponent } from './updatecustomer/updatecustomer.component';
import { CustomerDetailsComponent } from './customer-details/customer-details.component';
import {HomeComponent  } from './home/home.component';


const routes: Routes = [
  { path: '', redirectTo: 'bank', pathMatch: 'full' },
{ path: 'bankcustomer', component: ListcustomerComponent},
{ path: 'addcustomer', component: CreatecustomerComponent },
{ path: 'updatecustomer/:id', component: UpdatecustomerComponent },
{ path: 'customerdetails/:id', component: CustomerDetailsComponent },
{ path: 'home', component: HomeComponent }


];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
