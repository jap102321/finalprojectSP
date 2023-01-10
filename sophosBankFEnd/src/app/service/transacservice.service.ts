import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http'
import { Observable } from 'rxjs';
import { Transaction } from '../models/transaction';
@Injectable({
  providedIn: 'root'
})
export class TransacserviceService {
  transacURL = 'http://localhost:8080/transaction/'
  constructor(private httpClient : HttpClient) { }

  public transacList(accid:number) : Observable<Transaction[]>{
      return this.httpClient.get<Transaction[]>(this.transacURL + `transaclist/${accid}`)
  }

  
  public transac(transaction : Transaction) : Observable<any>{
    return this.httpClient.post<any>(this.transacURL + `inacc`, transaction)
  }
}
