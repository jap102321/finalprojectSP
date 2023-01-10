import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { CretransacRoutingModule } from './cretransac-routing.module';
import { CretransacComponent } from './cretransac.component';


@NgModule({
  declarations: [
    CretransacComponent
  ],
  imports: [
    CommonModule,
    CretransacRoutingModule
  ]
})
export class CretransacModule { }
