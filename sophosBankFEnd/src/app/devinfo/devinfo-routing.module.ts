import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { DevinfoComponent } from './devinfo.component';

const routes: Routes = [{ path: '', component: DevinfoComponent }];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class DevinfoRoutingModule { }
