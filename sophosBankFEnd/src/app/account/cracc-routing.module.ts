import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CraccComponent } from './cracc.component';

const routes: Routes = [{ path: '', component: CraccComponent }];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class CraccRoutingModule { }
