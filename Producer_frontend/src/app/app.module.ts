import { NgModule } from '@angular/core';
import { BrowserModule,Title } from '@angular/platform-browser';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { CreatecustomerComponent } from './createcustomer/createcustomer.component';
import { UpdatecustomerComponent } from './updatecustomer/updatecustomer.component';
import { ListcustomerComponent } from './listcustomer/listcustomer.component';
import {ReactiveFormsModule} from "@angular/forms";
import { CustomerDetailsComponent } from './customer-details/customer-details.component';
import { HomeComponent } from './home/home.component';

@NgModule({
  declarations: [
    AppComponent,
    CreatecustomerComponent,
    UpdatecustomerComponent,
    ListcustomerComponent,
    CustomerDetailsComponent,
    HomeComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule
  ],
  providers: [Title],
  bootstrap: [AppComponent]
})
export class AppModule { }
