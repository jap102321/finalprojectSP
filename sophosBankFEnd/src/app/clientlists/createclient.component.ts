import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { Client } from '../models/client';
import { ClientServiceService } from '../service/client-service.service';
@Component({
  selector: 'app-createclient',
  templateUrl: './createclient.component.html',
  styleUrls: ['./createclient.component.css']
})
export class CreateclientComponent implements OnInit {
idType : string = '';
name : string = '';
lastname : string = '';
document: any = '';
birthDate: Date = new Date();
creationDate: Date = new Date();
email : string = '';
updateUser : string = '';
updateDate : Date = new Date();


client : Client = new Client(this.idType, this.name,this.lastname,this.document,this.email,this.birthDate,this.creationDate,this.updateDate,this.updateUser);
constructor(private toastr: ToastrService ,private clientService : ClientServiceService,private router : Router){
}


ngOnInit(){
}


 onCreate(): void{
    let client : Client = new Client(this.idType, this.name,this.lastname,this.document,this.email,this.birthDate,this.creationDate,this.updateDate,this.updateUser);

     this.clientService.save(client).subscribe({
       next:(res)=> this.toastr.success('Cliente añadido', 'OK',{
         timeOut:3000
       }),
       error: (err) => this.toastr.error('Error al crear el cliente, revisa sus datos', 'Ok',{
         timeOut:3000
       }),
       complete: ()=> this.router.navigateByUrl("/clients")
     })
    console.log(this.client)
 }

}
