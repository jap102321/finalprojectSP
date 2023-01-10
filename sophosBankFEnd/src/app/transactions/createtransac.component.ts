import { Component, OnInit } from '@angular/core';
import { ClientServiceService } from '../service/client-service.service';
import { AccountserviceService } from '../service/accountservice.service';
import { Router, ActivatedRoute} from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { Transaction } from '../models/transaction';
import { TransacserviceService } from '../service/transacservice.service';

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
    constructor(private transacService : TransacserviceService,private activatedRoute : ActivatedRoute, private toastr : ToastrService, private clientService : ClientServiceService, private accountService : AccountserviceService, private router : Router){

    }

   


  ngOnInit(){
    
  }

  onTransac(){
    let transac: Transaction = new Transaction(this.account, this.transac_type, this.amount, this.transac_date)
    this.transacService.transac(transac).subscribe({
      next:(res)=> this.toastr.success('Cuenta añadida', 'OK',{
        timeOut:3000
      }),
      error: (err) => this.toastr.error('Error al crear la cuenta, revisa sus datos', 'Ok',{
        timeOut:3000
      }),
      complete: ()=> this.router.navigateByUrl("/clients")
    })
  }  


}
