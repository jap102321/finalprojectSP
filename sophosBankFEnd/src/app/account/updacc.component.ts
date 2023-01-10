import { Component } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { Accounts } from '../models/accounts';
import { AccountserviceService } from '../service/accountservice.service';
@Component({
  selector: 'app-updacc',
  templateUrl: './updacc.component.html',
  styleUrls: ['./updacc.component.css']
})
export class UpdaccComponent {
  account: any = '';

  constructor(
    private accountService : AccountserviceService,
    private activatedRoute : ActivatedRoute,
    private toastr : ToastrService,
    private router : Router
  ){

  }


  ngOnInit(){
    const id = this.activatedRoute.snapshot.params.id;
    this.accDetails(id)
  }

  accDetails(id:number){
    this.accountService.detailAcc(id).subscribe(
      data=>{
        this.account = data
      },
      err=>{
          console.log(err)
      }
    )
  }

  updAccount():void{
    const id = this.activatedRoute.snapshot.params.id;
    this.accountService.updateAcc(id, this.account).subscribe(
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
      }
      )
    }
  }


