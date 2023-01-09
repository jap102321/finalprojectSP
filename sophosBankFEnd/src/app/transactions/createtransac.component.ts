import { Component, OnInit } from '@angular/core';
import { Accounts } from '../models/accounts';
import { Client } from '../models/client';
import { ClientServiceService } from '../service/client-service.service';
import { AccountserviceService } from '../service/accountservice.service';
import { Router, ActivatedRoute} from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { Transaction } from '../models/transaction';

@Component({
  selector: 'app-createtransac',
  templateUrl: './createtransac.component.html',
  styleUrls: ['./createtransac.component.css']
})
export class CreatetransacComponent implements OnInit {
    account : any = '';
    transac_type : string = '';
    amount : any = '';
    transac_date : Date = new Date();

    transac: Transaction = new Transaction(this.account, this.transac_type, this.amount, this.transac_date)
    constructor(private activatedRoute : ActivatedRoute, private toastr : ToastrService, private clientService : ClientServiceService, private accountService : AccountserviceService, private router : Router){

    }

   


  ngOnInit(){
    const id = this.activatedRoute.snapshot.params.id;

  }

  onTransac(){
  }  


}
