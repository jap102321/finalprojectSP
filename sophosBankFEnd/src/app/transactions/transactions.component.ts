import { Component,OnInit } from '@angular/core';
import { Transaction } from '../models/transaction';
import { TransacserviceService } from '../service/transacservice.service';
import { ToastrService} from 'ngx-toastr';
import { Accounts } from '../models/accounts';
import { AccountserviceService } from '../service/accountservice.service';
import { Router, ActivatedRoute } from '@angular/router';
@Component({
  selector: 'app-transactions',
  templateUrl: './transactions.component.html',
  styleUrls: ['./transactions.component.css']
})
export class TransactionsComponent implements OnInit{

  transactions : Transaction[] = [];
  account : any = '';

  constructor(private accountService : AccountserviceService,private activatedRoute : ActivatedRoute,private toastr: ToastrService,private transacService : TransacserviceService, private Router : Router ){

  }


  ngOnInit(){
  const acc_id = this.activatedRoute.snapshot.params.id;
  this.loadAccount(acc_id)
  this.loadTransac(acc_id)
  }

  loadAccount(acc_id:number): void{
    this.accountService.detailAcc(acc_id).subscribe(
      data =>{
        this.account = data;
      }
    )
  }
  loadTransac(accid : number){
    this.transacService.transacList(accid).subscribe(
      data=>{
        this.transactions = data;
      },
      err=>{
        console.log(err)
      }
    )
  }
}
