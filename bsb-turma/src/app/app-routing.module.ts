import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { ResponsavelListarComponent } from './views/components/responsavel-crud/responsavelListar/responsavel-listar.component';
import { HomeComponent } from './views/components/template/home/home.component';
import { ResponsavelSalvarComponent} from "./views/components/responsavel-crud/responsavelSalvar/responsavel-salvar.component";

const routes: Routes = [
  {
    path:'',
    component: HomeComponent
  },
  {
    path:'responsavel',
    component: ResponsavelListarComponent
  },
  {
    path:'responsavel',
    component: ResponsavelSalvarComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
