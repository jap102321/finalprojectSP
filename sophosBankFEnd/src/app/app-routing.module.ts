import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

const routes: Routes = [{ path: 'dashboard', loadChildren: () => import('./account/account.module').then(m => m.AccountModule) }, { path: 'dashboard', loadChildren: () => import('./clientlists/clientlists.module').then(m => m.ClientlistsModule) }, { path: 'dashboard', loadChildren: () => import('./transactions/transactions.module').then(m => m.TransactionsModule) }];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
