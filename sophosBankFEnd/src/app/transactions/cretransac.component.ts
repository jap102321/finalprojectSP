import { Component, OnInit } from '@angular/core';
import { ClientServiceService } from '../service/client-service.service';
import { AccountserviceService } from '../service/accountservice.service';
import { Router, ActivatedRoute} from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { Transaction } from '../models/transaction';
import { TransacserviceService } from '../service/transacservice.service';
import {Accounts} from '../models/accounts';
import { Client } from '../models/client';

@Component({
  selector: 'app-cretransac',
  templateUrl: './cretransac.component.html',
  styleUrls: ['./cretransac.component.css']
})
export class CretransacComponent implements OnInit{
  client : Client;
  account : any = '';
  transac_type : string = '';
  amount : any = '';
  transac_date : Date = new Date();

  transac: Transaction = new Transaction(this.account, this.transac_type, this.amount, this.transac_date)
  constructor(private transacService : TransacserviceService,private activatedRoute : ActivatedRoute, private toastr : ToastrService, private clientService : ClientServiceService, private accountService : AccountserviceService, private router : Router){

  }

 


ngOnInit(){
  const acc_id = this.activatedRoute.snapshot.params.id;
  this.loadAccount(acc_id)
}

loadAccount(acc_id:number): void{
  this.accountService.detailAcc(acc_id).subscribe(
    data =>{
      this.account = data;
    }
  )
}

loadClient(id:number) : void{
  this.clientService.detail(id).subscribe(
    data =>{
      this.client = data;
    },
    err=>{
      console.log(err)
    }
  )
}

onTransac(){
  const acc_id = this.activatedRoute.snapshot.params.id;
  let transac: Transaction = new Transaction(this.account, this.transac_type, this.amount, this.transac_date)
   this.transacService.transac(transac).subscribe(
    data => {
      this.toastr.success('Producto Actualizado', 'OK', {
        timeOut: 3000, positionClass: 'toast-top-center'
      });
      this.router.navigate(['/clients/accounts', acc_id]);
    },
    err => {
      this.toastr.error(err.error.mensaje, 'Fail', {
        timeOut: 3000,  positionClass: 'toast-top-center',
      });
    })

  }  
}
