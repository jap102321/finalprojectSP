import { Component ,OnInit} from '@angular/core';
import { Router, ActivatedRoute} from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { Accounts } from '../models/accounts';
import { ClientServiceService } from '../service/client-service.service';
import { AccountserviceService } from '../service/accountservice.service';
import { Transaction } from '../models/transaction';

@Component({
  selector: 'app-cracc',
  templateUrl: './cracc.component.html',
  styleUrls: ['./cracc.component.css']
})
export class CraccComponent implements OnInit{
  client: any = '';
  accNumber : string = '';
  acc_type : string = '';
  balance : any = '';
  created_at: Date = new Date();
  updated_at : Date = new Date();
  acc_status: string = '';
  transaction : any='';


  
  acc : Accounts = new Accounts(this.client, this.accNumber,this.acc_type,this.balance,this.created_at,this.updated_at,this.acc_status, this.transaction);

  constructor(private activatedRoute : ActivatedRoute,private toastr : ToastrService, private clientService : ClientServiceService, private accountService : AccountserviceService, private router : Router ){

  }

ngOnInit(){
  const id = this.activatedRoute.snapshot.params.id;
  this.loadClient(id)
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

onCreateAcc(){
     let account : Accounts = new Accounts(this.client, this.accNumber,this.acc_type,this.balance,this.created_at,this.updated_at,this.acc_status, this.transaction)

     this.accountService.save(account).subscribe({
       next:(res)=> this.toastr.success('Cuenta añadida', 'OK',{
         timeOut:3000
       }),
       error: (err) => this.toastr.error('Error al crear la cuenta, revisa sus datos', 'Ok',{
         timeOut:3000
       }),
       complete: ()=> this.router.navigateByUrl("/clients")
     })
  console.log(this.acc)
  }
}
