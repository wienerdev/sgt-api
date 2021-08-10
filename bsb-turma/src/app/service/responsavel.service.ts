import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Responsavel} from "../model/responsavel.model";
import { environment } from 'src/environments/environment';
import {MatSnackBar} from "@angular/material/snack-bar";

@Injectable({
  providedIn: 'root'
})
export class ResponsavelService {

  baseUrl: String = environment.baseUrl;

  constructor(private http: HttpClient, private snack: MatSnackBar) {
  }

  listar(): Observable<Responsavel[]> {
    const url = this.baseUrl + "/api/reponsavel";
    return this.http.get<Responsavel[]>(url);
  }

  salvar(responsavel: Responsavel): Observable<Responsavel> {
    const url = this.baseUrl + "/api/responsavel";
    return this.http.post<Responsavel>(url, responsavel);
  }

  message(msg: String): void {
    this.snack.open(`${msg}`, 'OK', {
      horizontalPosition: 'end',
      verticalPosition: 'top',
      duration: 4000
    })
  }


}
