import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';


import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';




import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';

import {BrowserAnimationsModule} from "@angular/platform-browser/animations";
import {MatToolbarModule} from "@angular/material/toolbar";
import {MatIconModule} from "@angular/material/icon";
import {MatSidenavModule} from "@angular/material/sidenav";
import {MatListModule} from "@angular/material/list";
import {MatCardModule} from "@angular/material/card";
import {MatSelectModule} from "@angular/material/select";
import {MatTableModule} from "@angular/material/table";
import {MatDatepickerModule} from "@angular/material/datepicker";
import {MatInputModule} from "@angular/material/input";
import {MatPaginatorModule} from "@angular/material/paginator";
import {MatSnackBarModule} from "@angular/material/snack-bar";
import {MatButtonModule} from "@angular/material/button";
import {HeaderComponent} from "./views/components/template/header/header.component";
import {FooterComponent} from "./views/components/template/footer/footer.component";
import {HomeComponent} from "./views/components/template/home/home.component";

import {NavComponent} from "./views/components/template/nav/nav.component";
import {ResponsavelListarComponent} from "./views/components/responsavel-crud/responsavelListar/responsavel-listar.component";
import {ResponsavelSalvarComponent} from "./views/components/responsavel-crud/responsavelSalvar/responsavel-salvar.component";
import {ResponsavelDeletarComponent} from "./views/components/responsavel-crud/responsavelDeletar/responsavel-deletar.component";
import {ResponsavelAtualizarComponent} from "./views/components/responsavel-crud/responsavelAtualizar/responsavel-atualizar.component";



@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    FooterComponent,
    NavComponent,
    HomeComponent,
    ResponsavelListarComponent,
    ResponsavelSalvarComponent,
    ResponsavelAtualizarComponent,
    ResponsavelDeletarComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    BrowserAnimationsModule,
    HttpClientModule,
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    MatToolbarModule,
    MatSidenavModule,
    MatIconModule,
    MatButtonModule,
    MatListModule,
    MatCardModule,
    MatTableModule,
    MatSelectModule,
    MatInputModule,
    MatDatepickerModule,
    MatPaginatorModule,
    MatSnackBarModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
