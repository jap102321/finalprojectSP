import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CretransacComponent } from './cretransac.component';

const routes: Routes = [{ path: '', component: CretransacComponent }];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class CretransacRoutingModule { }
