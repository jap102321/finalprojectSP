import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { ClientlistsRoutingModule } from './clientlists-routing.module';
import { ClientlistsComponent } from './clientlists.component';


@NgModule({
  declarations: [
    ClientlistsComponent
  ],
  imports: [
    CommonModule,
    ClientlistsRoutingModule
  ]
})
export class ClientlistsModule { }
