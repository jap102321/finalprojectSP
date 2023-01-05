import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

const routes: Routes = [
 { path: '', loadChildren: () => import('./landing/landing.module').then(m => m.LandingModule) },
 { path: 'accounts', loadChildren: () => import('./account/account.module').then(m => m.AccountModule) },
 { path: 'clients', loadChildren: () => import('./clientlists/clientlists.module').then(m => m.ClientlistsModule) }, 
 { path: 'transactions', loadChildren: () => import('./transactions/transactions.module').then(m => m.TransactionsModule) }, 
 ];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
