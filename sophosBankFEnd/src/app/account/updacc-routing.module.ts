import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { UpdaccComponent } from './updacc.component';

const routes: Routes = [{ path: '', component: UpdaccComponent }];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class UpdaccRoutingModule { }
