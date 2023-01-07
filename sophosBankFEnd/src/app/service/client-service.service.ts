import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import { Observable } from 'rxjs';
import {Client} from '../models/client'
@Injectable({
  providedIn: 'root'
})
export class ClientServiceService {

  clientURL = 'http://localhost:8080/'
  constructor(private httpClient: HttpClient) { }


public list(): Observable<Client[]>{
  return this.httpClient.get<Client[]>(this.clientURL + `clientlist`);
}

public detail(id:number):Observable<Client>{
  return this.httpClient.get<Client>(this.clientURL + `clientdetail/${id}`);
}

public save(client : Client): Observable<any>{
  return this.httpClient.post<any>(this.clientURL + `registerclient`, client);
}

public update(id:number, client : Client): Observable<any>{

  return this.httpClient.put<any>(this.clientURL + `update/${id}`, client);

}

public delete(id:number): Observable<any>{
  return this.httpClient.delete<any>(this.clientURL + `delete/${id}`);
}

}

