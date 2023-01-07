import { Component, OnInit } from '@angular/core';
import { Cliente } from '../models/cliente';
import { ClientServiceService } from '../service/client-service.service';
@Component({
  selector: 'app-clientlists',
  templateUrl: './clientlists.component.html',
  styleUrls: ['./clientlists.component.css']
})
export class ClientlistsComponent implements OnInit{

  clientes : Cliente[] = [];

  constructor(private clientService: ClientServiceService){

  }

  ngOnInit(){
      this.loadClient();
  }


  loadClient() : void{
    this.clientService.list().subscribe(
      data =>{
        this.clientes = data;
      },
      err=>{
        console.log(err)
      }
    )
  }

  delete(id?:number){

    alert(`Borrando el cliente` + id)
  }

}
