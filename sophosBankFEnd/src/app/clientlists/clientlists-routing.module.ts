import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ClientlistsComponent } from './clientlists.component';
import { UpdateclientComponent } from './updateclient.component';

const routes: Routes = [{ path: '', component: ClientlistsComponent },
{path:'update/:id', component : UpdateclientComponent}]


@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class ClientlistsRoutingModule { }
