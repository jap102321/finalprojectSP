import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { CraccRoutingModule } from './cracc-routing.module';
import { CraccComponent } from './cracc.component';


@NgModule({
  declarations: [
    CraccComponent
  ],
  imports: [
    CommonModule,
    CraccRoutingModule
  ]
})
export class CraccModule { }
