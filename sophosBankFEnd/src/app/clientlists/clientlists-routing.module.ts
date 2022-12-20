import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ClientlistsComponent } from './clientlists.component';

const routes: Routes = [{ path: '', component: ClientlistsComponent }];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class ClientlistsRoutingModule { }
