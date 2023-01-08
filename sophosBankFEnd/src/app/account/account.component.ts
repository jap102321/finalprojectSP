import { Component,Inject,OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { Accounts } from '../models/accounts';
import { Client } from '../models/client';
import { AccountserviceService } from '../service/accountservice.service';


@Component({
  selector: 'app-account',
  templateUrl: './account.component.html',
  styleUrls: ['./account.component.css']
})

export class AccountComponent implements OnInit{
  accounts : Accounts[] = [];
  id: number ;

  

  constructor(private activatedRoute : ActivatedRoute,private tostr: ToastrService, private accountService : AccountserviceService, private router : Router){

  }



  ngOnInit(){
    const id = this.activatedRoute.snapshot.params.id;
    this.loadAccount(id);
  }

  loadAccount(id:number): void{
    this.accountService.accList(id).subscribe(
      data =>{
        this.accounts = data;
      },
      err=>{
        console.log(err)
      }
    )
  }
}
