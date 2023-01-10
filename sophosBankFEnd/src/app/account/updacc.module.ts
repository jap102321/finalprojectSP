import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ToastrModule } from 'ngx-toastr';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import {MatButtonModule} from '@angular/material/button';
import {MatDialogModule} from '@angular/material/dialog';
import {MatInputModule} from '@angular/material/input';
import { UpdaccRoutingModule } from './updacc-routing.module';
import { UpdaccComponent } from './updacc.component';


@NgModule({
  declarations: [
    UpdaccComponent
  ],
  imports: [
    CommonModule,
    UpdaccRoutingModule,
    ToastrModule,
    HttpClientModule,
    FormsModule,
    NgbModule,
    MatButtonModule,
    MatDialogModule,
    MatInputModule
  ]
})
export class UpdaccModule { }
