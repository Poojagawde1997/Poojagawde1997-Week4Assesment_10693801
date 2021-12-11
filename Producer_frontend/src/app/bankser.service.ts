import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class BankserService {

  constructor(private http:HttpClient) { }

  private baseurl='http://localhost:8768/api';
  //private baseUrl='http://localhost:8764/getbankcustomers';

  getcustomer():Observable<Object>{
   return this.http.get(`${this.baseurl}/getbankcustomer`);
  }

  getcustomerbyid(id:any):Observable<any>{
    return this.http.get(`${this.baseurl}/getbankcustomer/${id}`);
  }

  createcustomer(bank:Object):Observable<Object>{
    return this.http.post(`${this.baseurl}/addbankcustomer`,bank);
  }

  updatecustomer(id:any,value:any):Observable<any>{
    return this.http.put(`${this.baseurl}/updatebankcustomer/${id}`,value);
  }

  deletecustomer(id:any):Observable<any>{
    return this.http.delete(`${this.baseurl}/deletebankcustomer/${id}`,{ responseType: 'text' });
  }

}
