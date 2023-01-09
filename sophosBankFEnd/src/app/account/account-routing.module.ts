import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CreatetransacComponent } from '../transactions/createtransac.component';
import { AccountComponent } from './account.component';

const routes: Routes = [{ path: '', component: AccountComponent},
{path:'createtransac/:id', component: CreatetransacComponent }]

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class AccountRoutingModule { }
