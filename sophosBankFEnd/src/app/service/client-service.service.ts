import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import { Observable } from 'rxjs';
import {Cliente} from '../models/cliente'
@Injectable({
  providedIn: 'root'
})
export class ClientServiceService {

  clientURL = 'http://localhost:8080/'
  constructor(private httpClient: HttpClient) { }


public list(): Observable<Cliente[]>{
  return this.httpClient.get<Cliente[]>(this.clientURL + `clientlist`);
}

public detail(id:number):Observable<Cliente>{
  return this.httpClient.get<Cliente>(this.clientURL + `clientdetail/${id}`);
}


}

