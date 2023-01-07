import { Component, OnInit } from '@angular/core';
import { Client } from '../models/client';
import { ClientServiceService } from '../service/client-service.service';
import { ToastrService } from 'ngx-toastr';
import { Router } from '@angular/router';


@Component({
  selector: 'app-clientlists',
  templateUrl: './clientlists.component.html',
  styleUrls: ['./clientlists.component.css']
})
export class ClientlistsComponent implements OnInit{

  clients : Client[] = [];

  constructor(private toastr: ToastrService,private clientService: ClientServiceService,private router : Router){

  }

  ngOnInit(){
      this.loadClient();
  }


  loadClient() : void{
    this.clientService.list().subscribe(
      data =>{
        this.clients = data;
      },
      err=>{
        console.log(err)
      }
    )
  }

  delete(id?:number){
    if(id!=undefined){
    this.clientService.delete(id).subscribe({
      next:(res)=> this.toastr.success('Cliente eliminado', 'OK',{
      }),
      error: (err) => this.toastr.error('Error al eliminar, revisa sus datos', 'Ok',{
      }),
      complete: ()=> this.router.navigateByUrl("/clients")
    })
  }
 }
}
