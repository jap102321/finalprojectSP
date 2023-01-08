import { Component } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Toast, ToastrService } from 'ngx-toastr';
import { Client } from '../models/client';
import { ClientServiceService } from '../service/client-service.service';

@Component({
  selector: 'app-updateclient',
  templateUrl: './updateclient.component.html',
  styleUrls: ['./updateclient.component.css']
})
export class UpdateclientComponent {

  client: Client = null ;

  constructor(
    private clientService : ClientServiceService,
    private activatedRoute : ActivatedRoute,
    private toastr : ToastrService,
    private router : Router
  ){


  }

  ngOnInit() {
    const id = this.activatedRoute.snapshot.params.id;
    this.clientService.detail(id).subscribe(
      data => {
        this.client = data;
      },
      err => {
        this.toastr.error(err.error.mensaje, 'Fail', {
          timeOut: 3000,  positionClass: 'toast-top-center',
        });
        this.router.navigate(['/clients']);
      }
    );
  }

  onUpdate(): void {
    const id = this.activatedRoute.snapshot.params.id;
    this.clientService.update(id, this.client).subscribe(
      data => {
        this.toastr.success('Producto Actualizado', 'OK', {
          timeOut: 3000, positionClass: 'toast-top-center'
        });
        this.router.navigate(['/clients']);
      },
      err => {
        this.toastr.error(err.error.mensaje, 'Fail', {
          timeOut: 3000,  positionClass: 'toast-top-center',
        });
      }
    );
  }
}
