import { Component,Inject,OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { Accounts } from '../models/accounts';
import { Client } from '../models/client';
import { AccountserviceService } from '../service/accountservice.service';
import { ClientServiceService } from '../service/client-service.service';


@Component({
  selector: 'app-account',
  templateUrl: './account.component.html',
  styleUrls: ['./account.component.css']
})

export class AccountComponent implements OnInit{
  accounts : Accounts[] = [];
  clients : Client = null;
  id: number ;

  

  constructor(private activatedRoute : ActivatedRoute,private tostr: ToastrService, private accountService : AccountserviceService, private router : Router,private clientService : ClientServiceService){

  }



  ngOnInit(){
    const id = this.activatedRoute.snapshot.params.id;
    this.loadAccount(id);
    this.loadClient(id);
  }

  loadAccount(id:number): void{
    this.accountService.accList(id).subscribe(
      data =>{
        this.accounts = data;
      }
    )
  }

  loadClient(id:number) : void{
    this.clientService.detail(id).subscribe(
      data=>{
        this.clients = data
      },
      err=>{
        console.log(err)
      }
    )
  }

}
