import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { DevinfoRoutingModule } from './devinfo-routing.module';
import { DevinfoComponent } from './devinfo.component';


@NgModule({
  declarations: [
    DevinfoComponent
  ],
  imports: [
    CommonModule,
    DevinfoRoutingModule
  ]
})
export class DevinfoModule { }
