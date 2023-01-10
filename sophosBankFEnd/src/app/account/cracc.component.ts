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
  created_at: any = '';
  updated_at : any = '';
  acc_status: string = '';
  transaction : any='';


  
  acc : Accounts = new Accounts(this.client, this.accNumber,this.acc_type,this.balance,this.updated_at,this.acc_status, this.transaction);

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
  const id = this.activatedRoute.snapshot.params.id;

     let account : Accounts = new Accounts(this.client, this.accNumber,this.acc_type,this.balance,this.updated_at,this.acc_status, this.transaction)

     this.accountService.save(account).subscribe( 
      data => {
      this.toastr.success('Producto Actualizado', 'OK', {
        timeOut: 3000, positionClass: 'toast-top-center'
      });
      this.router.navigate(['/clients/accounts', id]);
    },
    err => {
      this.toastr.error(err.error.mensaje, 'Fail', {
        timeOut: 3000,  positionClass: 'toast-top-center',
      });
    })
  console.log(this.acc)
  }
}
