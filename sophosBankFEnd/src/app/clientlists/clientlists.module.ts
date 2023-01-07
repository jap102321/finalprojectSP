import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import { ClientlistsRoutingModule } from './clientlists-routing.module';
import { ClientlistsComponent } from './clientlists.component';
import { UpdateclientComponent } from './updateclient.component';


@NgModule({
  declarations: [
    ClientlistsComponent,
    UpdateclientComponent,
  ],
  imports: [
    CommonModule,
    ClientlistsRoutingModule,
    RouterModule
  ]
})
export class ClientlistsModule { }
