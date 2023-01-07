import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ClientlistsComponent } from './clientlists.component';
import { CreateclientComponent } from './createclient.component';
import { UpdateclientComponent } from './updateclient.component';

const routes: Routes = [{ path: '', component: ClientlistsComponent },
{path:'update/:id', component : UpdateclientComponent},
{path:'create', component: CreateclientComponent}
]


@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class ClientlistsRoutingModule { }
