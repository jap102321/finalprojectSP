import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import { Observable } from 'rxjs';
import { Accounts } from '../models/accounts';
import { Client } from '../models/client';
 @Injectable({
  providedIn: 'root'
})
export class AccountserviceService {
   
  id? : number;
  
  accURL = 'http://localhost:8080/accounts/'

  constructor(private httpClient : HttpClient) { }


  public accList(id?:number): Observable<Accounts[]>{
    return this.httpClient.get<Accounts[]>(this.accURL + `${id}`)
  }

}
